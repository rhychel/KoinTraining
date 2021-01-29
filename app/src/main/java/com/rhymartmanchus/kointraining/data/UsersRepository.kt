package com.rhymartmanchus.kointraining.data

import com.rhymartmanchus.kointraining.domain.User
import com.rhymartmanchus.kointraining.domain.UsersGateway
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UsersRepository : UsersGateway {

    override suspend fun addUser(user: User) {
        TODO("Not yet implemented")
    }

    override suspend fun removeUser(user: User) {
        TODO("Not yet implemented")
    }

    override suspend fun fetchUsers(): Flow<List<User>> = flow {
        emit(listOf(
            User(2, "Rhymart")
        ))
    }

    override suspend fun getUsers(): Flow<List<User>> = flow {
        emit(listOf(
            User(1, "Michelle"),
            User(3, "Gab")
        ))
    }

    override suspend fun getUserById(id: Int): Flow<User> {
        TODO("Not yet implemented")
    }

}