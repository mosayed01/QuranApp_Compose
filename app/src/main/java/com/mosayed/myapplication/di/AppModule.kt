package com.mosayed.myapplication.di

import com.mosayed.myapplication.data.remote.QuranService
import com.mosayed.myapplication.data.remote.QuranServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideQuranService(client: HttpClient): QuranService {
        return QuranServiceImpl(client = client)
    }

    @Provides
    @Singleton
    fun provideClient(): HttpClient {
        return HttpClient(CIO) {
            install(Logging) {
                level = LogLevel.BODY
            }
            install(ContentNegotiation) {
                json()
            }
        }
    }
}