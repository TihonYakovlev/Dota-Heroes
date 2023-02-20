package com.tihonyakovlev.dotaheroes.data.repository

import com.tihonyakovlev.dotaheroes.data.repository.params.HeroParams
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface DotaHeroesApi {
    @Headers("X-RapidAPI-Key: 87b39fc0c7msh8b27fd6667dbb5fp18f863jsna8f781e9cd66", "X-RapidAPI-Host: dota2-heroes.p.rapidapi.com")
    @GET("heroes/english")
    suspend fun getHeroes(): List<DotaHeroInfo>

    @Headers("X-RapidAPI-Key: 87b39fc0c7msh8b27fd6667dbb5fp18f863jsna8f781e9cd66", "X-RapidAPI-Host: dota2-heroes.p.rapidapi.com")
    @GET("heroes/russian/{id}")
    suspend fun getParams(@Path("id") id: Int): HeroParams
}