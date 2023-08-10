package com.mosayed.myapplication.data.remote.dto.sura

import kotlinx.serialization.Serializable

@Serializable
data class SuraDto(
    val englishName: String? = null,
    val englishNameTranslation: String? = null,
    val name: String? = null,
    val number: Int? = null,
    val numberOfAyahs: Int? = null,
    val revelationType: String? = null
)