package com.rhymartmanchus.kointraining.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FetchUserByIdUseCase
    : UseCase<FetchUserByIdUseCase.Param, FetchUserByIdUseCase.Response>() {

    data class Param (
        val id: Int
    )

    data class Response (
        val user: Flow<User>
    )

    override suspend fun run(param: Param): Response =
        Response(
            flow { User(1, "Rhymart Manchus") }
        )

}