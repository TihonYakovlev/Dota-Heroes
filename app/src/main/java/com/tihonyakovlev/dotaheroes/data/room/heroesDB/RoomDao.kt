package com.tihonyakovlev.dotaheroes.data.room.heroesDB

import androidx.room.*
import com.tihonyakovlev.dotaheroes.data.room.heroesDB.entities.DotaHeroInfoEntity
import com.tihonyakovlev.dotaheroes.data.room.heroesDB.entities.HeroParamsEntity
import com.tihonyakovlev.dotaheroes.data.room.heroesDB.entities.HeroParamsFromDbTupple

@Dao
interface RoomDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertHeroes(heroes: List<DotaHeroInfoEntity>)

    @Query("SELECT * FROM heroes")
    suspend fun getAllHeroes(): List<DotaHeroInfoEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertParams(params: HeroParamsEntity)

    @Query("SELECT * FROM parameters WHERE id = :id")
    suspend fun getDbParams(id: Int): HeroParamsEntity

    /*@Transaction
@Query("SELECT * FROM hero WHERE id = :id")
    suspend fun getHeroAndParamsWithID(id: Int): List<HeroAndParams>*/


}