package com.picpay.desafio.android.userlist.data.datasource

import com.picpay.desafio.android.network.extensions.safeCall
import com.picpay.desafio.android.network.model.Result
import com.picpay.desafio.android.network.model.ResultError
import com.picpay.desafio.android.userlist.data.api.UserApi
import com.picpay.desafio.android.userlist.data.model.User
import javax.inject.Inject


class RemoteDataSourceImpl @Inject constructor(
    private val userApi: UserApi
) : RemoteDataSource {

    override suspend fun getUsers(): Result<List<User>, ResultError> =
        safeCall {
            userApi.getUsers()
        }
}
