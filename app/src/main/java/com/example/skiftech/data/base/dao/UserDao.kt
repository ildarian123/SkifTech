package com.example.skiftech.data.base.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.skiftech.data.base.models.UserDb

@Dao
interface UserDao {
    @Query("SELECT * FROM users ")
    fun getAllUsers(): List<UserDb>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(userDb: UserDb?)

}
