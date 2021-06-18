package com.picpay.desafio.android.userlist.presentation.userlist

import androidx.lifecycle.MutableLiveData
import com.picpay.desafio.android.userlist.data.model.User


class UserListViewState {
    val list = MutableLiveData<List<User>>(emptyList())
    val state = MutableLiveData<State>(State.LOADING)

    enum class State {
        SUCCESS,
        LOADING,
        ERROR
    }
}
