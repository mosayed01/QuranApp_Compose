package com.mosayed.myapplication.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mosayed.myapplication.core.Aya
import com.mosayed.myapplication.core.Sura
import kotlinx.coroutines.flow.Flow

@Dao
interface QuranDao {

    ///Sura
    /**
     * @return list sura from db
     */
    @Query("select * from Sura order by number")
    fun getAllSura(): Flow<List<Sura>>

    /**
     * insert list of sura
     * @param sura list of sura
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllSura(sura: List<Sura>)


    ///Aya
    /**
     * @param sura number of sura as string
     * @return list aya from db
     */
    @Query("select * from Aya where sura = :sura")
    fun getAllAya(sura: String): Flow<List<Aya>>

    /**
     * insert list of aya
     * @param aya list of aya
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllAya(aya: List<Aya>)
}