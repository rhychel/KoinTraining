package com.rhymartmanchus.kointraining

import com.rhymartmanchus.kointraining.data.UsersRepository
import com.rhymartmanchus.kointraining.domain.UsersGateway
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UsersModule {

    @Binds
    abstract fun bindUsersGateway(
        usersRepository: UsersRepository
    ): UsersGateway

}