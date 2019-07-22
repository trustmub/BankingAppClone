package com.trustathanas.absaclone.common.widgets

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.DrawableRes
import com.jakewharton.rxbinding3.view.clicks
import com.trustathanas.absaclone.R
import kotlinx.android.synthetic.main.error_widget.view.*


class ErrorWidget : ConstraintLayout, View.OnClickListener {


    private var view: View

    private var executionMethod: Any

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        view = LayoutInflater.from(context).inflate(R.layout.error_widget, this, true)
        view.errorWidgetRetryButton.setOnClickListener(this)

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.ErrorWidget, defStyleAttr, 0)

        try {
            val errorIcon = typedArray.getResourceId(R.styleable.ErrorWidget_android_src, 0)

            view.errorWidgetIconImageView.setImageResource(errorIcon)

            executionMethod = typedArray.getNonResourceString(R.styleable.ErrorWidget_onClickRetry)

            view.errorWidgetMessageTextView.text = typedArray.getString(R.styleable.ErrorWidget_message)
                    ?: ""
            view.errorWidgetRetryButton.text = typedArray.getString(R.styleable.ErrorWidget_button_text)
                    ?: ""
            view.errorWidgetFooterTextView.text = typedArray.getString(R.styleable.ErrorWidget_footer_text)
                    ?: ""
            view.errorWidgetFooterTextView.visibility = typedArray.getInt(R.styleable.ErrorWidget_footer_visibility, View.GONE)


        } finally {
            typedArray.recycle()
        }
    }

//    override fun setOnClickListener(l: OnClickListener?) {
//        super.setOnClickListener(l)
//        println("clicked ${l} and $executionMethod")
//    }

    fun setIcon(@DrawableRes errorIcon: Int) {
        view.errorWidgetIconImageView.setImageResource(errorIcon)
    }

    fun setMessage(message: String) {
        view.errorWidgetMessageTextView.text = message
    }

    fun setButtonText(text: String) {
        view.errorWidgetRetryButton.text = text
    }

    fun setButtonClickListener(click: () -> Unit) {
        click()
    }

    fun setFooterText(text: String) {
        view.errorWidgetFooterTextView.text = text
    }

    fun setFooterVisibility(visibility: Int) {
        view.errorWidgetFooterTextView.visibility = visibility
    }

    //    /**
    override fun onClick(v: View?) {
        v?.let { viewId ->
            if (viewId.id == R.id.errorWidgetRetryButton) {
                println("retry clicked ${viewId.hasOnClickListeners()} and ${executionMethod}")
            }
        }
    }
//    **/

}
