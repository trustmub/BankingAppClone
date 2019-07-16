package com.trustathanas.absaclone

import android.os.Build
import com.trustathanas.absaclone.activities.auth.AuthResource
import com.trustathanas.absaclone.models.AuthResponse
import com.trustathanas.absaclone.models.Response
import io.mockk.impl.annotations.MockK
import org.junit.Before
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1], packageName = "com.trustathanas.absaclone")
class SessionManagerTest {

    @MockK
    private lateinit var sessionManager: SessionManager

    private lateinit var authResource: AuthResource<Response>

    @Before
    fun setup() {

    }

}