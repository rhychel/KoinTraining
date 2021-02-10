package com.rhymartmanchus.kointraining.domain

import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class FetchUsersUseCase @Inject constructor (
    val gateway: UsersGateway
) : UseCase<Unit, FetchUsersUseCase.Response>() {

    private val cache = mutableListOf<User>()

    data class Response (
        val users: Flow<List<User>>
    )

    override suspend fun run(param: Unit): Response {
        return Response(
                callbackFlow {
                    gateway.getUsers().collect {
                        cache.addAll(it)
                    }
                    offer(cache)

                    gateway.fetchUsers().collect {
                        cache.addAll(it)
                    }
                    offer(cache)
                }
        )
    }

}