package com.picpay.desafio.android.userlist.data.repository

import com.picpay.desafio.android.network.model.Result
import com.picpay.desafio.android.network.model.ResultError
import com.picpay.desafio.android.userlist.data.model.User


interface UserRepository {
    suspend fun loadUserList(): Result<List<User>, ResultError>
}
