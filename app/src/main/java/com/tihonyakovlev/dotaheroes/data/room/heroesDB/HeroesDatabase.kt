package com.tihonyakovlev.dotaheroes.data.room.heroesDB

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [HeroEntity::class, ParamsEntity::class], version = 2)
abstract class HeroesDatabase : RoomDatabase() {

    abstract fun heroesDao(): RoomDao

}