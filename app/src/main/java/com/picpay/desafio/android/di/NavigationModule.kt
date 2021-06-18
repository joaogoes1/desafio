package com.picpay.desafio.android.di

import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.picpay.desafio.android.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class NavigationModule {

    @Provides
    fun navController(activity: FragmentActivity): NavController {
        return activity.supportFragmentManager.findFragmentById(R.id.nav_host)?.let {
            NavHostFragment.findNavController(it)
        } ?: throw IllegalStateException("nav_host not found")
    }
}
