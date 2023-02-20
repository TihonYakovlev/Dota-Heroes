package com.tihonyakovlev.dotaheroes.presentation

import android.app.Application
import com.tihonyakovlev.dotaheroes.di.databaseModule
import com.tihonyakovlev.dotaheroes.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class DotaHeroesApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@DotaHeroesApplication)
            modules(repositoryModule, databaseModule)
        }
    }
}