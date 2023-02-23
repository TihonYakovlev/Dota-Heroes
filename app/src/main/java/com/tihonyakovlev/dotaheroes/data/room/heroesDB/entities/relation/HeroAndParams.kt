package com.tihonyakovlev.dotaheroes.data.room.heroesDB.entities.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.tihonyakovlev.dotaheroes.data.room.heroesDB.entities.DotaHeroInfoEntity
import com.tihonyakovlev.dotaheroes.data.room.heroesDB.entities.HeroParamsEntity

data class HeroAndParams(
    @Embedded val hero: DotaHeroInfoEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "id")
    val params: HeroParamsEntity

)
