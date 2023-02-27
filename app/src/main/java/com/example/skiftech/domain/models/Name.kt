package com.example.skiftech.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Name(
    val title: String? = null,
    val first: String? = null,
    val last: String? = null
) : Parcelable