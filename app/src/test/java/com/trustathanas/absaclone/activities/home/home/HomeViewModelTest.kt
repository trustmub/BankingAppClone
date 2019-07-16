package com.trustathanas.absaclone.activities.home.home

import android.os.Build
import com.trustathanas.absaclone.SessionManager
import com.trustathanas.absaclone.repositories.HomeRepository
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.SpyK
import org.junit.Before
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1], packageName = "com.trustathanas.absaclone")
class HomeViewModelTest {

    private lateinit var viewModel: HomeViewModel

    @MockK private lateinit var sessionManager: SessionManager

    @Before
    fun setUp() {
        viewModel = HomeViewModel(sessionManager)
    }

}