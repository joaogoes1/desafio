package com.picpay.desafio.android.userlist.data.repository

import com.picpay.desafio.android.network.model.Result
import com.picpay.desafio.android.network.model.ResultError
import com.picpay.desafio.android.userlist.data.datasource.RemoteDataSource
import com.picpay.desafio.android.userlist.data.model.User
import javax.inject.Inject


class UserRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : UserRepository {

    override suspend fun loadUserList(): Result<List<User>, ResultError> =
        remoteDataSource.getUsers()
}
