package com.rhymartmanchus.kointraining.domain

import kotlinx.coroutines.flow.Flow

interface UsersGateway {

    suspend fun addUser(user: User)
    suspend fun removeUser(user: User)

    suspend fun fetchUsers(): Flow<List<User>>
    suspend fun getUsers(): Flow<List<User>>
    suspend fun getUserById(id: Int): Flow<User>

}