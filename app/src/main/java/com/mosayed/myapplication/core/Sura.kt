package com.mosayed.myapplication.core

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Sura(
    val englishName: String,
    val englishNameTranslation: String,
    val name: String,
    @PrimaryKey val number: Int,
    val numberOfAyahs: Int,
    val revelationType: String
)