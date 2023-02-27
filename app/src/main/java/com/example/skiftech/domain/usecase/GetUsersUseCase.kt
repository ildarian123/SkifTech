package com.example.skiftech.domain.usecase

import com.example.skiftech.data.repositorys.UserRepositoryImpl
import com.example.skiftech.domain.models.UserResponse
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(private val userRepository: UserRepositoryImpl) {
    suspend fun execute(): UserResponse {
        return userRepository.getUsers()
    }
}