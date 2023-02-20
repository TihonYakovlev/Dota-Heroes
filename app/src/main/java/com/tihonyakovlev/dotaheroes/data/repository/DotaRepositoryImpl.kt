package com.tihonyakovlev.dotaheroes.data.repository

import com.tihonyakovlev.dotaheroes.data.repository.params.HeroParams
import com.tihonyakovlev.dotaheroes.data.room.heroesDB.HeroEntity
import com.tihonyakovlev.dotaheroes.data.room.heroesDB.RoomDao
import com.tihonyakovlev.dotaheroes.domain.repository.DotaRepository

class Mapper {
    fun map(model: DotaHeroInfo): HeroEntity {
        return HeroEntity(
            id = model.id,
            complexity = model.complexity,
            attribute_img = model.attribute_img,
            image = model.image,
            name_loc = model.name_loc
        )
    }
}

class EntityToHeroMapper {
    fun map(model: HeroEntity): DotaHeroInfo {
        return DotaHeroInfo(
            id = model.id,
            complexity = model.complexity,
            attribute_img = model.attribute_img,
            image = model.image,
            name_loc = model.name_loc
        )
    }
}

class DotaRepositoryImpl(
    private val dotaApi: DotaHeroesApi,
    private val dao: RoomDao,
    private val mapper: Mapper,
    private val reverseMapper: EntityToHeroMapper
) : DotaRepository {
    override suspend fun getHeroes(): List<DotaHeroInfo> {
        val heroesFromBd = dao.getAllHeroes()
        if (heroesFromBd.isNotEmpty()) {
            return heroesFromBd.map {
                reverseMapper.map(it)
            }
        }


        val heroes: List<DotaHeroInfo> = dotaApi.getHeroes()
        return heroes.also {
            val entityHeroes: List<HeroEntity> = heroes.map {
                mapper.map(it)
            }
            dao.insertHeroes(entityHeroes)
        }
    }

    override suspend fun getParams(id: Int): HeroParams {
        return dotaApi.getParams(id = id)
    }
}

