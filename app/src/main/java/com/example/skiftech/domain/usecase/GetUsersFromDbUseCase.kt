package com.example.skiftech.domain.usecase

import com.example.skiftech.data.base.models.UserDb
import com.example.skiftech.data.repositorys.DataBaseRepositoryImpl
import javax.inject.Inject

class GetUsersFromDbUseCase @Inject constructor(private val dataBaseRepository: DataBaseRepositoryImpl) {
    suspend fun execute(): List<UserDb> {
        return dataBaseRepository.getUsers()
    }
}