package com.trustathanas.absaclone.common.widgets

import android.app.Activity
import android.content.Context
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.google.common.base.Verify.verify
import com.nhaarman.mockitokotlin2.whenever
import com.trustathanas.absaclone.R
import kotlinx.android.synthetic.main.error_widget.view.*
import org.hamcrest.Matchers.`is`
import org.junit.Assert
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations.initMocks
import org.mockito.Spy
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config


@RunWith(RobolectricTestRunner::class)
@Config(sdk = [28], manifest = Config.NONE, packageName = "com.trustathanas.absaclone")
internal class ErrorWidgetTest {

    private lateinit var errorWidget: ErrorWidget

    @Spy
    private val spyContext: Context = Robolectric.buildActivity(Activity::class.java).get()

    @Mock
    private lateinit var mockInflater: LayoutInflater
    @Mock
    private lateinit var mockView: View
    @Mock
    private lateinit var mockTypedArray: TypedArray
    @Mock
    private lateinit var mockErrorIconImageView: ImageView
    @Mock
    private lateinit var mockErrorMessageTextView: TextView
    @Mock
    private lateinit var mockErrorRetryButton: Button
    @Mock
    private lateinit var mockErrorFooterTextView: TextView
    @Mock
    private lateinit var mockDrawable: Drawable

    @Before
    fun setup() {
        initMocks(this)

        doReturn(mockInflater).`when`(spyContext).getSystemService(Context.LAYOUT_INFLATER_SERVICE)
        whenever(mockInflater.inflate(ArgumentMatchers.eq(R.layout.error_widget), isA(ErrorWidget::class.java), eq(true))).thenReturn(mockView)

        doReturn(mockTypedArray).`when`(spyContext).obtainStyledAttributes(null, R.styleable.ErrorWidget, 0, 0)

        `when`<ImageView>(mockView.errorWidgetIconImageView).thenReturn(mockErrorIconImageView)
        `when`<TextView>(mockView.errorWidgetMessageTextView).thenReturn(mockErrorMessageTextView)
        `when`<TextView>(mockView.errorWidgetRetryButton).thenReturn(mockErrorRetryButton)
        `when`<TextView>(mockView.errorWidgetFooterTextView).thenReturn(mockErrorFooterTextView)
    }

    @Test
    fun on_construction_inflate_the_error_widget_layout() {
        errorWidget = ErrorWidget(spyContext)

        verify(mockInflater).inflate(R.layout.error_widget, errorWidget, true)
    }

    @Test
    fun on_construction_set_error_icon() {
        whenever(mockTypedArray.getResourceId(R.styleable.ErrorWidget_android_src, 0)).thenReturn(R.drawable.icn_chevron)

        errorWidget = ErrorWidget(spyContext)

        verify(mockErrorIconImageView).setImageResource(R.drawable.icn_chevron)
    }

    @Test
    fun on_construction_set_error_message() {
        val errorMessage = "This is an error message"
        whenever(mockTypedArray.getString(R.styleable.ErrorWidget_message)).thenReturn(errorMessage)

        errorWidget = ErrorWidget(spyContext)

        verify(mockErrorMessageTextView).text = errorMessage
    }

    @Test
    fun on_construction_set_retry_button_text() {
        val buttonText = "Try again"
        whenever(mockTypedArray.getString(R.styleable.ErrorWidget_button_text)).thenReturn(buttonText)

        errorWidget = ErrorWidget(spyContext)

        verify(mockErrorRetryButton).text = buttonText
    }

    @Test
    fun on_construction_set_footer_visibility_to_GONE() {
        whenever(mockTypedArray.getInt(R.styleable.ErrorWidget_footer_visibility, View.GONE)).thenReturn(View.GONE)

        errorWidget = ErrorWidget(spyContext)

        verify(mockErrorFooterTextView).visibility = View.GONE
    }

    @Test
    fun on_construction_set_footer_visibility_to_VISIBLE() {
        whenever(mockTypedArray.getInt(R.styleable.ErrorWidget_footer_visibility, View.GONE)).thenReturn(View.VISIBLE)

        errorWidget = ErrorWidget(spyContext)

        verify(mockErrorFooterTextView).visibility = View.VISIBLE
    }

    @Test
    fun on_construction_set_footer_visibility_to_INVISIBLE() {
        whenever(mockTypedArray.getInt(R.styleable.ErrorWidget_footer_visibility, View.GONE)).thenReturn(View.INVISIBLE)

        errorWidget = ErrorWidget(spyContext)

        verify(mockErrorFooterTextView).visibility = View.INVISIBLE
    }

    @Test
    fun on_construction_set_footer_text() {
        val footerText = "Need help? 0860 000 000"
        whenever(mockTypedArray.getString(R.styleable.ErrorWidget_footer_text)).thenReturn(footerText)

        errorWidget = ErrorWidget(spyContext)

        verify(mockErrorFooterTextView).text = footerText
    }

    @Test
    fun on_construction_set_footer_icon() {
        whenever(mockErrorFooterTextView.compoundDrawables).thenReturn(arrayOf(mockDrawable, null, null, null))

        errorWidget = ErrorWidget(spyContext)

        Assert.assertEquals(mockDrawable, mockErrorFooterTextView.compoundDrawables.first())
    }

    @Test
    fun setIcon_should_set_top_drawable_on_errorMessageTextView() {
        errorWidget = ErrorWidget(spyContext)
        errorWidget.setIcon(R.drawable.icn_chevron)

        verify(mockErrorIconImageView).setImageResource(R.drawable.icn_chevron)
    }

    @Test
    fun setMessage_should_set_text_on_errorMessageTextView() {
        val errorMessage = "This is an error message"

        errorWidget = ErrorWidget(spyContext)
        errorWidget.setMessage(errorMessage)

        verify(mockErrorMessageTextView).text = errorMessage
    }

    @Test
    fun setButtonText_should_set_text_on_errorWidgetRetryButton() {
        val buttonText = "Try again"

        errorWidget = ErrorWidget(spyContext)
        errorWidget.setButtonText(buttonText)

        verify(mockErrorRetryButton).text = buttonText
    }

    @Test
    fun setButtonClickListener_should_have_on_click_listener() {
        `when`<Button>(mockView.errorWidgetRetryButton).thenReturn(mockErrorRetryButton)
        var invoked = false
        val invokedFunc = { invoked = true }
        errorWidget = ErrorWidget(spyContext, null, 0)
        errorWidget.setButtonClickListener { invokedFunc }

        verify(mockErrorRetryButton).hasOnClickListeners()

        mockErrorRetryButton.performClick()

        verify(invoked)
    }

    @Test
    fun setFooterText_should_set_text_on_errorWidgetFooterTextView() {
        val footerText = "Need help? 0860 000 000"

        errorWidget = ErrorWidget(spyContext)
        errorWidget.setFooterText(footerText)

        verify(mockErrorFooterTextView).text = footerText
    }

    @Test
    fun setFooterVisibility_should_set_errorWidgetFooterTextView_visibility() {
        errorWidget = ErrorWidget(spyContext)

        errorWidget.setFooterVisibility(View.GONE)

        verify(mockErrorFooterTextView).visibility = View.GONE
    }
}