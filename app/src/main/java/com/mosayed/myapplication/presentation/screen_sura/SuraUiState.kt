package com.mosayed.myapplication.presentation.screen_sura

data class SuraUiState(
    val isLoading: Boolean = false,
    val suraList: List<SuraItem> = emptyList(),
    val lastRead: SuraItem? = null,
    val error: String = ""
){
    data class SuraItem(
        val suraNumber: Int,
        val name: String,
        val numberOfAyahs: Int,
        val revelationType: String
    )
}
