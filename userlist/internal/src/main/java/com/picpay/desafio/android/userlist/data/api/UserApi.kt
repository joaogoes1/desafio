package com.picpay.desafio.android.userlist.data.api

import com.picpay.desafio.android.userlist.data.model.User
import retrofit2.http.GET

interface UserApi {

    @GET("users")
    suspend fun getUsers(): List<User>
}