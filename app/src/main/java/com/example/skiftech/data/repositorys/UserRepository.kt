package com.example.skiftech.data.repositorys

import com.example.skiftech.domain.models.UserResponse

interface UserRepository {
    suspend fun getUsers(count: Int): UserResponse
}