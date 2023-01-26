package com.mosayed.myapplication.data.remote

import com.mosayed.myapplication.domain.model.Aya
import com.mosayed.myapplication.domain.model.Sura
import com.mosayed.quranapp.data.remote.util.HttpRouts
import com.mosayed.myapplication.data.remote.util.tryToCall
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.url

class QuranServiceImpl(
    private val client: HttpClient
) : QuranService {
    override suspend fun getSura(): List<Sura> {
        return tryToCall { client.get { url(HttpRouts.BASE_URL_SURA) } }
    }

    override suspend fun getAyat(number: Int): List<Aya> {
        return tryToCall { client.get { url(HttpRouts.getAyatBySuraNumber(number)) } }
    }
}