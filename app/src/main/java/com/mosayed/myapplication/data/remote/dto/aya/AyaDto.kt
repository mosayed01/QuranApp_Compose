package com.mosayed.myapplication.data.remote.dto.aya

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AyaDto(
    @SerialName("arabic_text")
    val arabicText: String,
    @SerialName("aya")
    val aya: String,
    @SerialName("footnotes")
    val footnotes: String,
    @SerialName("id")
    val id: String,
    @SerialName("sura")
    val sura: String,
    @SerialName("translation")
    val translation: String
)