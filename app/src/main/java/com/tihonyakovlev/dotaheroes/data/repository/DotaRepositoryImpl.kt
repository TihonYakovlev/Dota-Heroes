package com.tihonyakovlev.dotaheroes.data.repository

import com.tihonyakovlev.dotaheroes.data.repository.params.HeroParams
import com.tihonyakovlev.dotaheroes.data.room.heroesDB.entities.DotaHeroInfoEntity
import com.tihonyakovlev.dotaheroes.data.room.heroesDB.entities.HeroParamsEntity
import com.tihonyakovlev.dotaheroes.data.room.heroesDB.RoomDao
import com.tihonyakovlev.dotaheroes.domain.repository.DotaRepository

class ApiToEntityHeroesMapper {
    fun map(model: DotaHeroInfo): DotaHeroInfoEntity {
        return DotaHeroInfoEntity(
            id = model.id,
            complexity = model.complexity,
            attribute_img = model.attribute_img,
            image = model.image,
            name_loc = model.name_loc
        )
    }
}

class EntityToApiHeroesMapper {
    fun map(model: DotaHeroInfoEntity): DotaHeroInfo {
        return DotaHeroInfo(
            id = model.id,
            complexity = model.complexity,
            attribute_img = model.attribute_img,
            image = model.image,
            name_loc = model.name_loc
        )
    }
}


class ApiToEntityParamsMapper{
    fun map(model: HeroParams): HeroParamsEntity {
        return HeroParamsEntity(
            id = model.id,
            agi_base = model.agi_base,
            agi_gain = model.agi_gain,
            armor = model.armor,
            attack_range = model.attack_range,
            bio_loc = model.bio_loc,
            complexity = model.complexity,
            damage_max = model.damage_max,
            damage_min = model.damage_min,
            max_health = model.max_health,
            max_mana = model.max_mana,
            sight_range_day = model.sight_range_day,
            sight_range_night = model.sight_range_night,
            str_base = model.str_base,
            thumb_image = model.thumb_image,

        )
    }
}

class EntityToApiParamsMapper{
    fun map(model: HeroParamsEntity): HeroParams {
        return HeroParams(
            id = model.id,
            agi_base = model.agi_base,
            agi_gain = model.agi_gain,
            armor = model.armor,
            attack_range = model.attack_range,
            bio_loc = model.bio_loc,
            complexity = model.complexity,
            damage_max = model.damage_max,
            damage_min = model.damage_min,
            max_health = model.max_health,
            max_mana = model.max_mana,
            sight_range_day = model.sight_range_day,
            sight_range_night = model.sight_range_night,
            str_base = model.str_base,
            thumb_image = model.thumb_image,
        )
    }
}




class DotaRepositoryImpl(
    private val dotaApi: DotaHeroesApi,
    private val dao: RoomDao,
    private val mapper: ApiToEntityHeroesMapper,
    private val paramsMapper: ApiToEntityParamsMapper,
    private val reverseParamsMapper: EntityToApiParamsMapper,
    private val reverseMapper: EntityToApiHeroesMapper,

) : DotaRepository {
    override suspend fun getHeroes(): List<DotaHeroInfo> {
        val heroesFromBd = dao.getAllHeroes()
        if (heroesFromBd.isNotEmpty()) {
            return heroesFromBd.map {
                reverseMapper.map(it)
            }
        } else{
            val heroes: List<DotaHeroInfo> = dotaApi.getHeroes()
            return heroes.also {
                val entityHeroes: List<DotaHeroInfoEntity> = heroes.map {
                    mapper.map(it)
                }
                dao.insertHeroes(entityHeroes)
            }
        }
    }

    override suspend fun getParams(id: Int): HeroParams {
        val paramsFromDb = dao.getDbParams(id = id)

        if (paramsFromDb != null){
            return reverseParamsMapper.map(paramsFromDb)
        } else{
            val params: HeroParams = dotaApi.getParams(id = id)
            return params.also {
                val entityParams: HeroParamsEntity = paramsMapper.map(params)
                dao.insertParams(params = entityParams)
            }
        }

       /* return dotaApi.getParams(id = id)*/
    }
}

