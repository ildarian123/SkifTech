package com.example.skiftech.data.repositorys

import com.example.skiftech.data.base.dao.UserDao
import com.example.skiftech.data.base.models.UserDb
import javax.inject.Inject

class DataBaseRepositoryImpl @Inject constructor(private val dao: UserDao) :
    DataBaseRepository {

    override suspend fun saveUsers(usersDb: List<UserDb>) {
        usersDb.forEach {
            dao.insertUser(it)
        }

    }

    override suspend fun getUsers(): List<UserDb> {
        return dao.getAllUsers()
    }
}