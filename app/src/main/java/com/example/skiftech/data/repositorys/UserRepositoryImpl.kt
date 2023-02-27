package com.example.skiftech.data.repositorys

import com.example.skiftech.data.network.NetworkApi
import com.example.skiftech.domain.models.UserResponse
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val networkApi: NetworkApi): UserRepository {

    override suspend fun getUsers(): UserResponse {
        val result = networkApi.getUsers(10)
        return result.body()?: UserResponse()
    }

}