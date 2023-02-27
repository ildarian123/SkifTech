package com.example.skiftech.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserResponse(
    val results: List<User>? = null,
    val Info: Info? = null
): Parcelable