package com.tihonyakovlev.dotaheroes.domain.repository

import com.tihonyakovlev.dotaheroes.data.repository.DotaHeroInfo
import com.tihonyakovlev.dotaheroes.data.repository.params.HeroParams

interface DotaRepository {
    suspend fun getHeroes(): List<DotaHeroInfo>
    suspend fun getParams(id: Int): HeroParams
}