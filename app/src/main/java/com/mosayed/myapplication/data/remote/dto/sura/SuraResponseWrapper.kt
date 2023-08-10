package com.mosayed.myapplication.data.remote.dto.sura

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SuraResponseWrapper(
    @SerialName("code")
    val code: Int? = null,
    @SerialName("data")
    val date: List<SuraDto>? = null,
    @SerialName("status")
    val status: String? = null
)