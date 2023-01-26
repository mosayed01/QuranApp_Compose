package com.mosayed.quranapp.data.remote.util

object HttpRouts {
    const val BASE_URL_SURA = "http://api.alquran.cloud/v1/surah"
    private const val BASE_URL_AYA = "https://quranenc.com/api/v1/translation/sura/english_rwwad"

    fun getAyatBySuraNumber(number: Int) : String = "$BASE_URL_AYA/$number" // For specific sura
}