package com.mosayed.myapplication.di

import com.mosayed.myapplication.data.remote.QuranService
import com.mosayed.myapplication.data.remote.QuranServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideQuranService(): QuranService {
        return QuranServiceImpl(
            client = HttpClient(Android){
                install(Logging){
                    level = LogLevel.ALL
                }
                install(JsonFeature){
                    serializer = KotlinxSerializer()
                }
            }
        )
    }
}