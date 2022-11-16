package com.mosayed.myapplication.domain.repository

import com.mosayed.myapplication.core.Aya
import com.mosayed.myapplication.core.Sura
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun getAllSura(): Flow<List<Sura>>
    fun getAllAya(sura: String): Flow<List<Sura>>

    suspend fun insertAllAya(aya: List<Aya>)
    suspend fun insertAllSura(sura: List<Sura>)
}