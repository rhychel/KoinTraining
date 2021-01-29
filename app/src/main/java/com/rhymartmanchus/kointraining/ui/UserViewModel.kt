package com.rhymartmanchus.kointraining.ui

import android.util.Log
import androidx.lifecycle.*
import com.rhymartmanchus.kointraining.data.UsersRepository
import com.rhymartmanchus.kointraining.domain.AppDispatcher
import com.rhymartmanchus.kointraining.domain.FetchUserByIdUseCase
import com.rhymartmanchus.kointraining.domain.FetchUsersUseCase
import com.rhymartmanchus.kointraining.domain.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class UserViewModel : ViewModel(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = viewModelScope.coroutineContext

    private val fetchUsersUseCase: FetchUsersUseCase by lazy {
        FetchUsersUseCase(UsersRepository())
    }

    private val _cachedUsers: MutableLiveData<List<User>> = MutableLiveData()

    val users: LiveData<List<User>> = _cachedUsers

    init {
        launch {
            fetchUsersUseCase.execute(Unit).users.collect {
                _cachedUsers.value = it
            }
        }
    }

    fun addUser() {
        launch {
            fetchUsersUseCase.execute(Unit).users.collect {
                _cachedUsers.postValue(it)
            }
        }
    }

}