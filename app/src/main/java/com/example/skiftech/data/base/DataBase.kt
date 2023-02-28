package com.example.skiftech.data.base

import android.content.Context
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import com.example.skiftech.data.base.dao.UserDao
import com.example.skiftech.data.base.models.UserDb

@Database(entities = [UserDb::class], version = 1)
abstract class DataBase: RoomDatabase() {
    private var db: DataBase? = null

    open fun getDataBase(applicationContext: Context?): DataBase? {
        if (db == null) {
            db = databaseBuilder(
                applicationContext!!,
                DataBase::class.java, "user_data_base"
            )
                .allowMainThreadQueries()
                .build()
        }
        return db
    }

    abstract fun userDao(): UserDao?
}