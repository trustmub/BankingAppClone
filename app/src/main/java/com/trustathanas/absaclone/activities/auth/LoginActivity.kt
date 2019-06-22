package com.trustathanas.absaclone.activities.auth

import android.annotation.SuppressLint
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.content.ContextCompat
import android.view.View
import com.trustathanas.absaclone.App
import com.trustathanas.absaclone.R
import com.trustathanas.absaclone.SessionManager
import com.trustathanas.absaclone.activities.TermsActivity
import com.trustathanas.absaclone.activities.contactus.ContactsActivity
import com.trustathanas.absaclone.activities.home.MainActivity
import com.trustathanas.absaclone.activities.resetaccount.RestPasscodeActivity
import com.trustathanas.absaclone.models.Login
import com.trustathanas.absaclone.models.LoginModel
import com.trustathanas.absaclone.viewmodels.LoginViewModel
import com.trustathanas.absaclone.viewmodels.ViewModelProviderFactory
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject


class LoginActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    @Inject
    lateinit var sessionManager: SessionManager


//    var disposables = CompositeDisposable()


    val tag: String = "LoginActivity"
    fun getLayout(): Int = com.trustathanas.absaclone.R.layout.activity_login

    private lateinit var loginViewModel: LoginViewModel

    var passcodeSequence: MutableList<Int> = mutableListOf()
    val passcodeLiveData: MutableLiveData<List<Int>> = MutableLiveData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        this.init()
        this.subscribeObservers()
        listenToClicks()
    }

    private fun init() {
        loginViewModel = ViewModelProviders.of(this, providerFactory).get(LoginViewModel::class.java)
    }

    private fun subscribeObservers() {
        loginViewModel.observerAuthState().observe(this, Observer { userAuthResource ->
            userAuthResource?.let { userResource ->
                when (userResource.status) {
                    AuthResource.Status.LOADING -> {
                        showProgressBar(true)
                    }
                    AuthResource.Status.AUTHENTICATED -> {
                        showProgressBar(false)
                        resetMarker()
                        startActivity(Intent(this, MainActivity::class.java))
                        // set the session values and navigate to the home page
                    }
                    AuthResource.Status.ERROR -> {
                        println("could not Error ${userAuthResource.data}")
                        resetMarker()
                        showProgressBar(false)
                        // show dialog of failed login
                    }
                    AuthResource.Status.NOT_AUTHENTICATED -> {
                        println("could not authenticate")
                        showProgressBar(false)
                    }
                }
            }
        })

        passcodeLiveData.observe(this, Observer {
            it?.let {
                if (it.size == 5) attemptLogin()
            }
        })
    }

    private fun showProgressBar(status: Boolean) {
        if (status) loading_layout.visible() else loading_layout.gone()
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
        App.prefes.username = "trustmub@gmail.com"
        App.prefes.fullname = "Trust Mubaiwa"
        App.prefes.passCode = 12345
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


        val passcodeCount = passcodeSequence.size
        when (passcodeCount) {
            1 -> v_one.setBackground(color)
            2 -> v_two.setBackground(color)
            3 -> v_three.setBackground(color)
            4 -> v_four.setBackground(color)
            5 -> v_five.setBackground(color)
        }
    }

    private fun resetMarker() {
        passcodeSequence.clear()
        val color = ContextCompat.getDrawable(this, R.drawable.passcode_markers)
        v_one.setBackground(color)
        v_two.setBackground(color)
        v_three.setBackground(color)
        v_four.setBackground(color)
        v_five.setBackground(color)

    }


    @SuppressLint("CommitTransaction")
    private fun showDialog(fragment: DialogFragment) {
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


    /** Click functions for loginActivity */

    fun onResetPassCodeClicked(view: View) {
        val resetIntent = Intent(this, RestPasscodeActivity::class.java)
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

    /*************************************/
}
