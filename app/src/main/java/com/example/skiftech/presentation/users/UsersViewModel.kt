package com.example.skiftech.presentation.users

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.skiftech.domain.models.User
import com.example.skiftech.domain.models.UserResponse
import com.example.skiftech.domain.usecase.GetUsersFromNetworkUseCase
import com.example.skiftech.domain.usecase.SaveUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val getUsersFromNetworkUseCase: GetUsersFromNetworkUseCase, private val saveUsersUseCase: SaveUsersUseCase
) : ViewModel() {
    private val scope = CoroutineScope(Dispatchers.IO)

    var users: MutableLiveData<UserResponse> = MutableLiveData()

    fun getUsers(count: Int) {
        scope.launch {
            users.postValue(getUsersFromNetworkUseCase.execute(count))
        }
    }

    fun saveUsers(listOfUsers: List<User>) {
        scope.launch {
            saveUsersUseCase.execute(listOfUsers)
        }
    }


}