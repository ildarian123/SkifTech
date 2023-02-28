package com.example.skiftech.domain.usecase

import com.example.skiftech.data.repositorys.UserRepositoryImpl
import com.example.skiftech.domain.models.UserResponse
import javax.inject.Inject

class GetUsersFromNetworkUseCase @Inject constructor(private val userRepository: UserRepositoryImpl) {
    suspend fun execute(count: Int): UserResponse {
        return userRepository.getUsers(count)
    }
}