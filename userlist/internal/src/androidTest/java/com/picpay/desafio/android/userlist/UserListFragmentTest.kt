package com.picpay.desafio.android.userlist

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.MediumTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.runner.AndroidJUnitRunner
import com.picpay.desafio.android.userlist.presentation.userlist.UserListFragment
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@MediumTest
@HiltAndroidTest
@ExperimentalCoroutinesApi
//@RunWith(AndroidJUnit4ClassRunner::class)
class UserListFragmentTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)
    private lateinit var navController: TestNavHostController

    @Before
    fun setUp() {
        navController = TestNavHostController(
            ApplicationProvider.getApplicationContext()
        )
        InstrumentationRegistry.getInstrumentation().runOnMainSync {
            navController.setGraph(R.navigation.user_list_graph)
        }
        launchFragmentInHiltContainer<UserListFragment> {
            Navigation.setViewNavController(requireView(), navController)
        }
    }

    @Test
    fun onSuccess_showUsers() {
        onView(withId(R.id.progressBar)).check(matches(isDisplayed()))
    }
}

class TestNavHostController(context: Context) : NavController(context)

