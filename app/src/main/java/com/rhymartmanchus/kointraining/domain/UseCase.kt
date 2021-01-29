package com.rhymartmanchus.kointraining.domain

abstract class UseCase<Param, Result> {

    abstract suspend fun run(param: Param): Result

    suspend fun execute(param: Param): Result = run(param)

}