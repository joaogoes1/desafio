package com.picpay.desafio.android.userlist.data.datasource

import android.accounts.NetworkErrorException
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.picpay.desafio.android.network.model.Result
import com.picpay.desafio.android.network.model.ResultError
import com.picpay.desafio.android.testcommons.MainCoroutineRule
import com.picpay.desafio.android.userlist.data.api.UserApi
import com.picpay.desafio.android.userlist.data.datasource.RemoteDataSource
import com.picpay.desafio.android.userlist.data.datasource.RemoteDataSourceImpl
import com.picpay.desafio.android.userlist.data.model.User
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class RemoteDataSourceTest {

    private val userApi: UserApi = mockk()
    private val remoteDataSource: RemoteDataSource = RemoteDataSourceImpl(userApi)

    @Test
    fun `getUsers with success should return Success`() = runBlocking {
        val userList = listOf(User(1, "Test", "test123", "https://test.com"))
        val expected = Result.Success(userList)
        coEvery { userApi.getUsers() } returns userList

        val result = remoteDataSource.getUsers()

        assertEquals(expected, result)
    }

    @Test
    fun `getUsers with fail should return Error`() = runBlocking {
        val expected = Result.Error(ResultError.UnknownError)
        coEvery { userApi.getUsers() } throws NetworkErrorException()

        val result = remoteDataSource.getUsers()

        assertEquals(expected, result)
    }
}