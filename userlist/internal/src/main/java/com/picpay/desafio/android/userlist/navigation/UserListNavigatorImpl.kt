package com.picpay.desafio.android.userlist.navigation

import androidx.navigation.NavController
import com.picpay.desafio.android.userlist.R
import javax.inject.Inject

class UserListNavigatorImpl @Inject constructor(
    private val navController: NavController,
) : UserListNavigator {

    override fun openUserListScreen() {
        navController.navigate(R.id.open_user_list)
    }
}
