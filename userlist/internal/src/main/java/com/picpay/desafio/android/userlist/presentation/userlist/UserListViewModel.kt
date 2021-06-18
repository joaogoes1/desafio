package com.picpay.desafio.android.userlist.presentation.userlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.picpay.desafio.android.userlist.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {
    val viewState = UserListViewState()

    fun loadUserList() {
        viewState.state.postValue(UserListViewState.State.LOADING)
        viewModelScope.launch {
            userRepository
                .loadUserList()
                .onSuccess {
                    viewState.list.postValue(it)
                    viewState.state.postValue(UserListViewState.State.SUCCESS)
                }
                .onError {
                    viewState.state.postValue(UserListViewState.State.ERROR)
                }
        }
    }
}
