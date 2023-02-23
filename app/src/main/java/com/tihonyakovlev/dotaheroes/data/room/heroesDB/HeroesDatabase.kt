package com.tihonyakovlev.dotaheroes.data.room.heroesDB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tihonyakovlev.dotaheroes.data.room.heroesDB.entities.DotaHeroInfoEntity
import com.tihonyakovlev.dotaheroes.data.room.heroesDB.entities.HeroParamsEntity

@Database(entities = [DotaHeroInfoEntity::class, HeroParamsEntity::class], version = 1, exportSchema = true)
abstract class HeroesDatabase : RoomDatabase() {

    abstract fun heroesDao(): RoomDao

}