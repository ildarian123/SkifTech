package com.example.skiftech.data.repositorys

import com.example.skiftech.data.network.NetworkApi
import com.example.skiftech.domain.models.UserResponse
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val networkApi: NetworkApi): UserRepository {

    override suspend fun getUsers(count: Int): UserResponse {
        val result = networkApi.getUsers(count)
        return result.body()?: UserResponse()
    }
}