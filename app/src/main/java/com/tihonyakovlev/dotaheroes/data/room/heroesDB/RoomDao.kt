package com.tihonyakovlev.dotaheroes.data.room.heroesDB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tihonyakovlev.dotaheroes.data.repository.params.HeroParams

@Dao
interface RoomDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertHeroes(heroes: List<HeroEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertParams(params: HeroParams)

    @Query("SELECT * FROM parameters")
    fun getDbParams(): HeroParams

    @Query("SELECT * FROM heroes")
    suspend fun getAllHeroes(): List<HeroEntity>
}