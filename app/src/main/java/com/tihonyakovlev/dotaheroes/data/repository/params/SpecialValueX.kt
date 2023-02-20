package com.tihonyakovlev.dotaheroes.data.repository.params

data class SpecialValueX(
    val bonuses: List<Any>,
    val heading_loc: String,
    val is_percentage: Boolean,
    val name: String,
    val values_float: List<Int>
)