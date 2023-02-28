package com.example.skiftech.domain.usecase

import com.example.skiftech.data.base.models.UserDb
import com.example.skiftech.data.repositorys.DataBaseRepositoryImpl
import com.example.skiftech.domain.models.User
import javax.inject.Inject

class SaveUsersUseCase @Inject constructor(private val dataBaseRepository: DataBaseRepositoryImpl) {
    suspend fun execute(listOfUsers: List<User>) {
        val usersDbList = mutableListOf<UserDb>()
        listOfUsers.forEach {
            val userDb = UserDb()
            userDb.id = it.id?.value.toString()
            userDb.firstName = it.name?.first.toString()
            userDb.lastName = it.name?.last.toString()
            userDb.gender = it.gender.toString()
            userDb.email = it.email.toString()
            userDb.location = it.location.toString()
            userDb.picture = it.picture?.medium
            usersDbList.add(userDb)
        }

        dataBaseRepository.saveUsers(usersDbList)
    }
}