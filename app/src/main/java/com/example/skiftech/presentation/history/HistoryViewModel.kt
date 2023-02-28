package com.example.skiftech.presentation.history

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.skiftech.data.base.models.UserDb
import com.example.skiftech.domain.models.User
import com.example.skiftech.domain.models.UserResponse
import com.example.skiftech.domain.usecase.GetUsersFromDbUseCase
import com.example.skiftech.domain.usecase.GetUsersFromNetworkUseCase
import com.example.skiftech.domain.usecase.SaveUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val getUsersFromDbUseCase: GetUsersFromDbUseCase
) : ViewModel() {
    private val scope = CoroutineScope(Dispatchers.IO)

    var users: MutableLiveData<List<UserDb>> = MutableLiveData()

    fun getUsers() {
        scope.launch {
            users.postValue(getUsersFromDbUseCase.execute())
        }
    }
}