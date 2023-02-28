package com.example.skiftech.data.base.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
class UserDb {

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    var id = ""

    @ColumnInfo(name = "firstName")
    var firstName: String? = null

    @ColumnInfo(name = "lastName")
    var lastName: String? = null

    @ColumnInfo(name = "gender")
    var gender: String? = null

    @ColumnInfo(name = "email")
    var email: String? = null

    @ColumnInfo(name = "location")
    var location: String? = null

    @ColumnInfo(name = "picture")
    var picture: String? = null
}