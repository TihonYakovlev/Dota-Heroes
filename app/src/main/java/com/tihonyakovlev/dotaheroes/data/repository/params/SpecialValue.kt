package com.tihonyakovlev.dotaheroes.data.repository.params

data class SpecialValue(
    val bonuses: List<Bonuse>,
    val heading_loc: String,
    val is_percentage: Boolean,
    val name: String,
    val values_float: List<Double>
)