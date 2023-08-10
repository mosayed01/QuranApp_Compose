package com.mosayed.myapplication.data.remote.dto.aya

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AyaResponseWrapper(
    @SerialName("result")
    val ayaDto: List<AyaDto>
)