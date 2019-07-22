package com.trustathanas.absaclone.activities.auth

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import android.os.Build
import com.trustathanas.absaclone.App
import com.trustathanas.absaclone.models.Login
import com.trustathanas.absaclone.repositories.LoginRepository
import junit.framework.Assert.assertNotNull
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config


@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1], packageName = "com.trustathanas.absaclone")
class LoginViewModelTest {

    @io.mockk.impl.annotations.MockK
    private lateinit var loginViewModel: LoginViewModel

    @io.mockk.impl.annotations.MockK
    private lateinit var repository: LoginRepository

    private lateinit var loginActivity: LoginActivity


    @Before
    fun setUp() {
        loginActivity = Robolectric.setupActivity(LoginActivity::class.java)
        loginViewModel = ViewModelProviders.of(loginActivity).get(LoginViewModel::class.java)
    }

    @Test
    fun `check if login user returns the login object`() {
        val userDetails = Login(account = 33600929, pin = 12345, user_number = 1)
        loginViewModel.loginUser(userDetails)
        val response = loginViewModel.authorisationState
        assertNotNull(response)
        assertThat(AuthResource.Status.AUTHENTICATED, equalTo(response.value?.status))
//        assertThat(userDetails.account.toString(), equalTo(response.value?.data?.customer?.accountNumber.toString()))
    }
}