package com.tihonyakovlev.dotaheroes.di

import androidx.room.Room
import com.tihonyakovlev.dotaheroes.data.room.heroesDB.HeroesDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


val databaseModule = module {
        single {
            Room.databaseBuilder(
                androidContext(),
                HeroesDatabase::class.java,
                name = "heroesDB"
            ).fallbackToDestructiveMigration().build().heroesDao()
        }
    }