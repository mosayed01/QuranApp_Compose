package com.mosayed.myapplication.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mosayed.myapplication.core.Aya
import com.mosayed.myapplication.core.Sura

@Database(entities = [Sura::class, Aya::class], version = 1, exportSchema = false)
abstract class QuranDatabase : RoomDatabase() {
    abstract val quranDao: QuranDao
}