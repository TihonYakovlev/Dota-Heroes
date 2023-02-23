package com.tihonyakovlev.dotaheroes.data.room.heroesDB.entities

data class HeroParamsFromDbTupple(
    val id: Int,
    val agi_base: Int,
    val agi_gain: Double,
    val armor: Double,
    val attack_range: Int,
    val bio_loc: String,
    val complexity: Int,
    val damage_max: Int,
    val damage_min: Int,
    val max_health: Int,
    val max_mana: Int,
    val sight_range_day: Int,
    val sight_range_night: Int,
    val str_base: Int,
    val thumb_image: String
)
