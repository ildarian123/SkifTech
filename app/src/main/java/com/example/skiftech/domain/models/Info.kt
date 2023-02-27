package com.example.skiftech.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Info(
    val seed: String? = null,
    val results: Int? = null,
    val page: Int? = null,
    val version: String? = null
) : Parcelable