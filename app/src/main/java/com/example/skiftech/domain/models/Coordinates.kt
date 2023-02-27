package com.example.skiftech.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Coordinates(

    val latitude: String? = null,
    val longitude: String? = null
): Parcelable