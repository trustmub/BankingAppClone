package com.trustathanas.absaclone.di.Auth

import android.app.Application
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import retrofit2.Retrofit

internal class AuthModuleTest {
    @Mock
    private lateinit var mockApplication: Application

    @Mock
    private lateinit var retrofit: Retrofit

    @Before
    fun setUp() {
    }

    @Test
    fun `providesAuthService$app`() {
        val compatAction = AuthModule.providesAuthService(retrofit)
    }

    @Test
    fun `providesLoginDao$app`() {
    }
}