package com.picpay.desafio.android.userlist.di

import com.picpay.desafio.android.userlist.data.repository.UserRepository
import com.picpay.desafio.android.userlist.data.repository.UserRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindsUserRepository(
        UserRepositoryImpl: UserRepositoryImpl
    ): UserRepository
}