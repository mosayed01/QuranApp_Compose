package com.mosayed.myapplication.data.remote

import com.mosayed.myapplication.domain.model.Aya
import com.mosayed.myapplication.domain.model.Sura

interface QuranService {
    suspend fun getSura(): List<Sura>
    suspend fun getAyat(number: Int): List<Aya>
}