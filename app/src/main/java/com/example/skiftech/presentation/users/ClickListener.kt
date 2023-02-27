package com.example.skiftech.presentation.users

import com.example.skiftech.domain.models.User

interface ClickListener {
    fun onClick(user: User)
}