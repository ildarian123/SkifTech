package com.example.skiftech.data.network

import com.example.skiftech.domain.models.UserResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkApi {

    @GET("/api/")
    suspend fun getUsers(
        @Query("results") results: Int,
    ): Response<UserResponse>
}