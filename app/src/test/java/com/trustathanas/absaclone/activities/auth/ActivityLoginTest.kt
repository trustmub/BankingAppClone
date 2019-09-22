package com.trustathanas.absaclone.activities.auth

import android.content.Intent
import android.os.Build
import android.widget.Button
import android.widget.TextView
import com.trustathanas.absaclone.R
import com.trustathanas.absaclone.activities.TermsActivity
import com.trustathanas.absaclone.activities.resetaccount.ResetPasscodeActivity
import junit.framework.Assert.assertNotNull
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric

import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows
import org.robolectric.Shadows.shadowOf
import org.robolectric.annotation.Config
import org.robolectric.shadows.ShadowActivity
import org.robolectric.shadows.ShadowIntent

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1], packageName = "com.trustathanas.absaclone")
class ActivityLoginTest {

    private lateinit var activityLogin: ActivityLogin

    private lateinit var resetPassCodeActivity: ResetPasscodeActivity
    private lateinit var termsActivity: TermsActivity

    @Before
    fun setUp() {
        activityLogin = Robolectric.setupActivity(ActivityLogin::class.java)

        resetPassCodeActivity = Robolectric.buildActivity(ResetPasscodeActivity::class.java).get()
        termsActivity = Robolectric.buildActivity(TermsActivity::class.java).get()

    }

    @Test
    fun `check if clicking reset button takes you to reset activity`() {
        val button = activityLogin.findViewById<Button>(R.id.btn_forgot_password)
        // assert not null
        assertNotNull(button)
        // perform click
        button.performClick()
        // assert reset restpasscord has been
        val showActivity: ShadowActivity = Shadows.shadowOf(resetPassCodeActivity)
        val intent: Intent = showActivity.nextStartedActivity
        val shadowIntent: ShadowIntent = shadowOf(intent)
        assertThat(shadowIntent.intentClass.name, equalTo(ResetPasscodeActivity::class.java.name))
    }

    @Test
    fun `check if clicking on terms and condition takes you to terms activity`() {
        val button = activityLogin.findViewById<TextView>(R.id.tv_login_ts_and_cs)
        assertNotNull(button)

        button.performClick()

        val showActivity: ShadowActivity = Shadows.shadowOf(termsActivity)
        val intent: Intent= showActivity.nextStartedActivity
        val shadowIntent: ShadowIntent = shadowOf(intent)
        assertThat(shadowIntent.intentClass.name, equalTo(TermsActivity::class.java.name))
    }

}