package com.picpay.desafio.android.userlist.data.datasource

import com.picpay.desafio.android.network.model.Result
import com.picpay.desafio.android.network.model.ResultError
import com.picpay.desafio.android.userlist.data.model.User


interface RemoteDataSource {
    suspend fun getUsers(): Result<List<User>, ResultError>
}
