package com.trustathanas.absaclone.activities.auth

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.trustathanas.absaclone.App
import com.trustathanas.absaclone.R
import com.trustathanas.absaclone.SessionManager
import com.trustathanas.absaclone.activities.TermsActivity
import com.trustathanas.absaclone.activities.contactus.ContactsActivity
import com.trustathanas.absaclone.activities.home.MainActivity
import com.trustathanas.absaclone.activities.resetaccount.ResetPasscodeActivity
import com.trustathanas.absaclone.databinding.ActivityLoginBinding
import com.trustathanas.absaclone.models.Login
import com.trustathanas.absaclone.models.LoginModel
import com.trustathanas.absaclone.viewmodels.ViewModelProviderFactory
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject


class ActivityLogin : DaggerAppCompatActivity() {

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    @Inject
    lateinit var sessionManager: SessionManager

    private lateinit var binding: ActivityLoginBinding
    private lateinit var loginViewModel: LoginViewModel


    val tag: String = "ActivityLogin"
    fun getLayout(): Int = R.layout.activity_login


    var passcodeSequence: MutableList<Int> = mutableListOf()
    val passcodeLiveData: MutableLiveData<List<Int>> = MutableLiveData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, getLayout(), null)

        loginViewModel = ViewModelProviders.of(this, providerFactory).get(LoginViewModel::class.java)

        binding.viewModel = loginViewModel

        this.subscribeObservers()
        listenToClicks()
    }

    private fun subscribeObservers() {
        loginViewModel.observerAuthState().observe(this, Observer { userAuthResource ->
//            userAuthResource?.let { userResource ->
//                loginViewModel.actionOnResponse(userResource)
//            }
        })

        loginViewModel.getViewState().observe(this, Observer {
            when (it) {
                is LoginViewModel.ViewState.LoadingState -> {
                    loading_layout.isVisible = true
                }
                is LoginViewModel.ViewState.SuccessState -> {
                    loading_layout.isVisible = false
                    navigateToHomeScreen()
                }
                is LoginViewModel.ViewState.FailedState -> {
                    loading_layout.isVisible = false
                }
            }
        })

        passcodeLiveData.observe(this, Observer {
            it?.let {
                if (it.size == 5) attemptLogin()
            }
        })
    }

    private fun listenToClicks() {

        tv_login_user_label.text = App.prefes.fullname
        btn_one.numberButtonClicked(1)
        btn_two.numberButtonClicked(2)
        btn_three.numberButtonClicked(3)
        btn_four.numberButtonClicked(4)
        btn_five.numberButtonClicked(5)
        btn_six.numberButtonClicked(6)
        btn_seven.numberButtonClicked(7)
        btn_eight.numberButtonClicked(8)
        btn_nine.numberButtonClicked(9)
        btn_zero.numberButtonClicked(0)
        btn_delete.deleteButtonClicked()

        setDefaultUser()
//        getAllUsers()

    }

    private fun attemptLogin() {
        var code: String = ""
        passcodeSequence.forEach { code += it.toString() }
        loginViewModel.loginUser(Login(33600929, code.toInt(), 1))

    }

    private fun setDefaultUser() {
        loginViewModel.manuallyAddUser(LoginModel(username = "trustmub@gmail.com", fullname = "Trust Mubaiwa", passCode = 12345))
        if (App.prefes.username.isNullOrEmpty()) App.prefes.username = "trustmub@gmail.com"
        if (App.prefes.fullname.isNullOrEmpty()) App.prefes.fullname = "Trust Mubaiwa"
        if (App.prefes.passCode.equals(null)) App.prefes.passCode = 12345
    }


    private fun processPasscodeInput(key: Int) {
        passcodeSequence.add(key)
        processMarker("a")
    }

    private fun processPasscodeDelete() {
        if (passcodeSequence.size != 0) {
            processMarker("d")
            passcodeSequence.removeAt(passcodeSequence.size - 1)
        }
    }

    private fun processMarker(action: String) {

        val color = if (action == "a")
            ContextCompat.getDrawable(this, R.drawable.passcode_marker_full) else
            ContextCompat.getDrawable(this, R.drawable.passcode_markers)

        passcodeLiveData.postValue(passcodeSequence)


        when (passcodeSequence.size) {
            1 -> v_one.background = color
            2 -> v_two.background = color
            3 -> v_three.background = color
            4 -> v_four.background = color
            5 -> v_five.background = color
        }
    }

    private fun resetMarker() {
        passcodeSequence.clear()
        val color = ContextCompat.getDrawable(this, R.drawable.passcode_markers)
        v_one.background = color
        v_two.background = color
        v_three.background = color
        v_four.background = color
        v_five.background = color

    }


    @SuppressLint("CommitTransaction")
    private fun showDialog(fragment: androidx.fragment.app.DialogFragment) {
        val transaction = supportFragmentManager.beginTransaction()

        val previouseDialog = supportFragmentManager.findFragmentByTag("dialog")
        if (previouseDialog != null) transaction.remove(previouseDialog)
        fragment.show(transaction, "dialog")
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }

    private fun dismissDialog() {
        val transaction = supportFragmentManager.beginTransaction()
        val previouseDialog = supportFragmentManager.findFragmentByTag("dialog")
        if (previouseDialog != null) transaction.remove(previouseDialog).commit()
    }


    /**View Extension Function */

    private fun View.numberButtonClicked(button: Int) {
        this.setOnClickListener {
            processPasscodeInput(button)
        }
    }

    private fun View.deleteButtonClicked() {
        this.setOnClickListener {
            processPasscodeDelete()
        }
    }

    private fun View.gone() {
        this.visibility = View.GONE
    }

    private fun View.visible() {
        this.visibility = View.VISIBLE
    }

    /**********************************/

    /** Navigation conditions **/

    private fun navigateToHomeScreen() {
        val resetIntent = Intent(this, MainActivity::class.java)
        startActivity(resetIntent)
    }


    /** Click functions for loginActivity */

    fun onResetPassCodeClicked(view: View) {
        val resetIntent = Intent(this, ResetPasscodeActivity::class.java)
        startActivity(resetIntent)
    }

    fun onTermsAndConditionsClicked(View: View) {
        val termsIntent = Intent(this, TermsActivity::class.java)
        startActivity(termsIntent)
    }

    fun onContactUsClicked(view: View) {
        val contactsIntent = Intent(this, ContactsActivity::class.java)
        startActivity(contactsIntent)
    }

    override fun onDestroy() {
        super.onDestroy()
        passcodeLiveData.removeObservers(this)
    }
}
