package com.example.skiftech.presentation.users

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.skiftech.domain.models.UserResponse
import com.example.skiftech.domain.usecase.GetUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase,
) : ViewModel() {
    private val scope = CoroutineScope(Dispatchers.IO)

    var users: MutableLiveData<UserResponse> = MutableLiveData()

    fun getUsers() {
        scope.launch {
            users.postValue(getUsersUseCase.execute())
        }
    }


}