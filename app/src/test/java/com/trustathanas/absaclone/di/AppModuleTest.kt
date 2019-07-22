package com.trustathanas.absaclone.di

import org.junit.Assert.assertSame
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import java.util.concurrent.ExecutorService

@RunWith(RobolectricTestRunner::class)
internal class AppModuleTest {

    private lateinit var executor: ExecutorService

    @Before
    fun setUp() {
        executor = AppModule.providesThreadPoolInstance()
    }

    @Test
    fun `providesThreadPoolInstance$app`() {
        val provider = AppModule.providesThreadPoolInstance()
        assertSame(executor, provider)
    }

    @Test
    fun `providesRetrofit Instance$app`() {
    }

    @Test
    fun `provideDatabaseInstance$app`() {
    }

    @Test
    fun `providesRequestOptions$app`() {
    }

    @Test
    fun `providesGlideInstance$app`() {
    }

    @Test
    fun `provideAppDrawable$app`() {
    }
}