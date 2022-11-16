package com.mosayed.myapplication.data.remote

import com.mosayed.myapplication.core.Aya
import com.mosayed.myapplication.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface AyaApi {
    @GET("/translation/sura/{translation_key}/{sura_number}")
    suspend fun getAyat(
        @Path("translation_key") translation_key: String = Constants.TRANSLATION_KEY,
        @Path("sura_number") sura_number: String
    ): Response<List<Aya>>
}