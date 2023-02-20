package com.tihonyakovlev.dotaheroes.data.room.heroesDB

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "heroes")
data class HeroEntity(
    @PrimaryKey
    val id: Int,
    val attribute_img: String,
    val complexity: Int,
    val image: String,
    val name_loc: String
)
