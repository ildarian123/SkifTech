package com.example.skiftech.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Street(
    val number: Int? = null,
    val name: String? = null
) : Parcelable