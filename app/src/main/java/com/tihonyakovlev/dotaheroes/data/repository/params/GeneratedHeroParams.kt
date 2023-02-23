package com.tihonyakovlev.dotaheroes.data.repository.params

data class GeneratedHeroParams(
    val agi_base: Int,
    val agi_gain: Double,
    val armor: Double,
    val attack_range: Int,
    val bio_loc: String,
    val complexity: Int,
    val damage_max: Int,
    val damage_min: Int,
    val id: Int,
    val max_health: Int,
    val max_mana: Int,
    val sight_range_day: Int,
    val sight_range_night: Int,
    val str_base: Int,
    val thumb_image: String,

    val abilities: List<Ability>,
    val attack_rate: Double,
    val attribute_img: String,
    val attack_capability: Int,
    val health_regen: Double,
    val hype_loc: String,
    val int_base: Int,
    val int_gain: Double,
    val magic_resistance: Int,
    val mana_regen: Double,
    val movement_speed: Int,
    val name: String,
    val name_loc: String,
    val npe_desc_loc: String,
    val order_id: Int,
    val primary_attr: Int,
    val projectile_speed: Int,
    val role_levels: List<Int>,
    val roles: Roles,
    val str_gain: Double,
    val talents: List<Talent>,
    val thumb_video: String,
    val turn_rate: Double
)



