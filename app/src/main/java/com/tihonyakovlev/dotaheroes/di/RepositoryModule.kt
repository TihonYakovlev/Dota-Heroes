package com.tihonyakovlev.dotaheroes.di

import com.tihonyakovlev.dotaheroes.data.repository.*
import com.tihonyakovlev.dotaheroes.domain.repository.DotaRepository
import com.tihonyakovlev.dotaheroes.presentation.viewmodels.DetailsViewModel
import com.tihonyakovlev.dotaheroes.presentation.viewmodels.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import retrofit2.Retrofit


val repositoryModule = module {
    single {
        ProvideRetrofit.provideRetrofit()
    }
    single {
        get<Retrofit>().create(DotaHeroesApi::class.java)
    }

    singleOf(::DotaRepositoryImpl){ bind<DotaRepository>() }
    single { ApiToEntityHeroesMapper() }
    single { EntityToApiHeroesMapper() }
    single { EntityToApiParamsMapper() }
    single { ApiToEntityParamsMapper() }

    viewModel{
        MainViewModel(get())
    }

    viewModelOf(::DetailsViewModel)

}