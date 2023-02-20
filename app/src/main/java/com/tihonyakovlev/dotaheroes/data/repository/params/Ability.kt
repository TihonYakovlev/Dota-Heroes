package com.tihonyakovlev.dotaheroes.data.repository.params

data class Ability(
    val ability_has_scepter: Boolean,
    val ability_has_shard: Boolean,
    val ability_is_granted_by_scepter: Boolean,
    val ability_is_granted_by_shard: Boolean,
    val behavior: String,
    val cast_points: List<Double>,
    val cast_ranges: List<Int>,
    val channel_times: List<Double>,
    val cooldowns: List<Double>,
    val damage: Int,
    val damages: List<Int>,
    val desc_loc: String,
    val dispellable: Int,
    val durations: List<Double>,
    val flags: Int,
    val gold_costs: List<Any>,
    val id: Int,
    val immunity: Int,
    val is_item: Boolean,
    val item_cost: Int,
    val item_initial_charges: Int,
    val item_neutral_tier: Long,
    val item_quality: Int,
    val item_stock_max: Int,
    val item_stock_time: Int,
    val lore_loc: String,
    val mana_costs: List<Int>,
    val max_level: Int,
    val name: String,
    val name_loc: String,
    val notes_loc: List<String>,
    val scepter_loc: String,
    val shard_loc: String,
    val special_values: List<SpecialValue>,
    val target_team: Int,
    val target_type: Int,
    val thumb_image: String,
    val type: Int,
    val video_mp4: String,
    val video_webm: String
)