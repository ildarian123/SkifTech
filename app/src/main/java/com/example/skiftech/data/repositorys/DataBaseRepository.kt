package com.example.skiftech.data.repositorys

import com.example.skiftech.data.base.models.UserDb

interface DataBaseRepository {
    suspend fun saveUsers(usersDb: List<UserDb>)
    suspend fun getUsers(): List<UserDb>
}