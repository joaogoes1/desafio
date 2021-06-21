package com.picpay.desafio.android.userlist.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.picpay.desafio.android.testcommons.MainCoroutineRule
import com.picpay.desafio.android.testcommons.getOrAwaitValue
import com.picpay.desafio.android.network.model.Result
import com.picpay.desafio.android.network.model.ResultError
import com.picpay.desafio.android.userlist.data.model.User
import com.picpay.desafio.android.userlist.data.repository.UserRepository
import com.picpay.desafio.android.userlist.presentation.userlist.UserListViewModel
import com.picpay.desafio.android.userlist.presentation.userlist.UserListViewState
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test


@ExperimentalCoroutinesApi
class UserListViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val coroutineRule = MainCoroutineRule()

    private val repository: UserRepository = mockk()
    private val viewModel = UserListViewModel(repository)

    @Test
    fun `when load users with success, emit success state`() = runBlockingTest {
        val expected = listOf(User(1, "", "", ""))
        coEvery { repository.loadUserList() } returns Result.Success(expected)

        viewModel.loadUserList()

        assertEquals(UserListViewState.State.SUCCESS, viewModel.viewState.state.getOrAwaitValue())
        assertEquals(expected, viewModel.viewState.list.getOrAwaitValue())
    }

    @Test
    fun `when load users returns error, emit error state`() = runBlockingTest {
        coEvery { repository.loadUserList() } returns Result.Error(ResultError.UnknownError)

        viewModel.loadUserList()

        assertEquals(UserListViewState.State.ERROR, viewModel.viewState.state.getOrAwaitValue())
        assertEquals(emptyList<User>(), viewModel.viewState.list.getOrAwaitValue())
    }
}