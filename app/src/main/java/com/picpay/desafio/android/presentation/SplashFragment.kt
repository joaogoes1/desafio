package com.picpay.desafio.android.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.picpay.desafio.android.R
import com.picpay.desafio.android.userlist.navigation.UserListNavigator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class SplashFragment : Fragment(R.layout.splash_fragment), CoroutineScope by CoroutineScope(Dispatchers.Main) {

    @Inject
    lateinit var userListNavigator: UserListNavigator

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        launch {
            delay(2000)
            userListNavigator.openUserListScreen()
        }
    }
}