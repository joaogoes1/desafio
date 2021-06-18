package com.picpay.desafio.android.userlist.di

import com.picpay.desafio.android.userlist.navigation.UserListNavigator
import com.picpay.desafio.android.userlist.navigation.UserListNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class NavigationModule {

    @Binds
    abstract fun bindsUserListNavigator(
        userListNavigatorImpl: UserListNavigatorImpl
    ): UserListNavigator
}