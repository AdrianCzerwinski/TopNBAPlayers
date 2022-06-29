package com.adrianczerwinski.topnbaplayers.di

import com.adrianczerwinski.topnbaplayers.data.local.NBAHeroesDatabase
import com.adrianczerwinski.topnbaplayers.data.remote.NBAApi
import com.adrianczerwinski.topnbaplayers.data.repository.RemoteDataSourceImpl
import com.adrianczerwinski.topnbaplayers.domain.repository.RemoteDataSource
import com.adrianczerwinski.topnbaplayers.util.Constants.BASE_URL
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@ExperimentalSerializationApi
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofitInstance(okHttpClient: OkHttpClient): Retrofit {
        val contentType = MediaType.get("application/json")
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(Json.asConverterFactory(contentType = contentType))
            .build()
    }

    @Provides
    @Singleton
    fun provideNBAApi(retrofit: Retrofit): NBAApi {
        return retrofit.create(NBAApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRemoteDataSource(
        NBAApi: NBAApi,
        NBAHeroesDatabase: NBAHeroesDatabase
    ): RemoteDataSource {
        return RemoteDataSourceImpl(
            NBAApi = NBAApi,
            NBAHeroesDatabase = NBAHeroesDatabase
        )
    }

}