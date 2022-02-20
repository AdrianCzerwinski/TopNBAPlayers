package com.adrianczerwinski.topnbaplayers.data.remote

import com.adrianczerwinski.topnbaplayers.domain.model.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface BorutoApi {

    @GET("/nba/heroes")
    suspend fun getAllHeroes(
        @Query("page") page: Int = 1
    ): ApiResponse

    @GET("/nba/heroes/search")
    suspend fun searchHeroes(
        @Query("name") name: String
    ): ApiResponse

}