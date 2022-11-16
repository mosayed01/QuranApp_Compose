package com.mosayed.myapplication.data.remote

import com.mosayed.myapplication.core.Sura
import com.mosayed.myapplication.utils.Constants
import retrofit2.Response
import retrofit2.http.GET

interface SuraApi {
    @GET(Constants.END_POINT_SURA)
    suspend fun getAllSura(): Response<List<Sura>>
}