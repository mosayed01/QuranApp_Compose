package com.mosayed.myapplication.core

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Aya(
    val arabic_text: String,
    val aya: String,
    val footnotes: String,
    val id: String,
    @PrimaryKey val sura: String,
    val translation: String
)