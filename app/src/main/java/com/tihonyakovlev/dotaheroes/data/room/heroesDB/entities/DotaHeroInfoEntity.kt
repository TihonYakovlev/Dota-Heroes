package com.tihonyakovlev.dotaheroes.data.room.heroesDB.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "heroes")
data class DotaHeroInfoEntity(
    @PrimaryKey
    val id: Int,
    val attribute_img: String,
    val complexity: Int,
    val image: String,
    val name_loc: String
)
