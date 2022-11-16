package com.mosayed.myapplication.data.repository

import com.mosayed.myapplication.core.Aya
import com.mosayed.myapplication.core.Sura
import com.mosayed.myapplication.data.local.db.QuranDao
import com.mosayed.myapplication.data.remote.AyaApi
import com.mosayed.myapplication.data.remote.SuraApi
import com.mosayed.myapplication.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val dao: QuranDao,
    private val ayaApi: AyaApi,
    private val suraApi: SuraApi
) : Repository {

    override fun getAllSura(): Flow<List<Sura>> = flow {
        val response = suraApi.getAllSura()
        if (response.isSuccessful)
            response.body()?.let { insertAllSura(it) }

        dao.getAllSura()
    }

    override fun getAllAya(sura: String): Flow<List<Sura>> = flow {
        val response = ayaApi.getAyat(sura_number = sura)
        if (response.isSuccessful)
            response.body()?.let { insertAllAya(it) }

        dao.getAllAya(sura)
    }

    override suspend fun insertAllAya(aya: List<Aya>) {
        dao.insertAllAya(aya)
    }

    override suspend fun insertAllSura(sura: List<Sura>) {
        dao.insertAllSura(sura)
    }
}