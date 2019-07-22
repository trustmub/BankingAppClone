package com.trustathanas.absaclone

import org.junit.Before
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [27])
abstract class BaseTest {
    @Before
    open fun setUp() {
    }
}