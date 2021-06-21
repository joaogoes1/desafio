package com.picpay.desafio.android.userlist.data.repository

import com.picpay.desafio.android.network.model.Result
import com.picpay.desafio.android.network.model.ResultError
import com.picpay.desafio.android.userlist.data.datasource.RemoteDataSource
import com.picpay.desafio.android.userlist.data.model.User
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class UserRepositoryTest {

    private val dataSource: RemoteDataSource = mockk()
    private val repository: UserRepository = UserRepositoryImpl(dataSource)

    @Test
    fun `getUsers with success should return Success`() = runBlocking {
        val userList = listOf(User(1, "Test", "test123", "https://test.com"))
        val expected = Result.Success(userList)
        coEvery { dataSource.getUsers() } returns Result.Success(userList)

        val result = repository.loadUserList()

        Assert.assertEquals(expected, result)
    }

    @Test
    fun `getUsers with fail should return Error`() = runBlocking {
        val expected = Result.Error(ResultError.UnknownError)
        coEvery { dataSource.getUsers() } returns Result.Error(ResultError.UnknownError)

        val result = repository.loadUserList()

        Assert.assertEquals(expected, result)
    }
}