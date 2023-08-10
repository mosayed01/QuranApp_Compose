package com.mosayed.myapplication.data.remote.util

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


suspend fun <T> tryToCall(call: suspend () -> T): T? {
    return try {
        withContext(Dispatchers.IO) {
            call()
        }
    } catch (e: Exception) {
        println("Error: ${e.message}")
        null
    }
}