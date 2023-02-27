package com.example.skiftech.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Dob(

    val date: String? = null,
    val age: Int? = null
): Parcelable