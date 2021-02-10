package com.rhymartmanchus.kointraining.ui

import android.util.Log
import androidx.lifecycle.*
import com.rhymartmanchus.kointraining.domain.FetchUsersUseCase
import com.rhymartmanchus.kointraining.domain.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@HiltViewModel
class UserViewModel @Inject constructor (
    val fetchUsersUseCase: FetchUsersUseCase
) : ViewModel(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = viewModelScope.coroutineContext

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