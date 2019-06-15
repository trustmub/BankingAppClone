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
import com.trustathanas.absaclone.activities.BaseActivity
import com.trustathanas.absaclone.activities.TermsActivity
import com.trustathanas.absaclone.activities.contactus.ContactsActivity
import com.trustathanas.absaclone.activities.home.MainActivity
import com.trustathanas.absaclone.activities.resetaccount.PasscodeLockedActivity
import com.trustathanas.absaclone.activities.resetaccount.RestPasscodeActivity
import com.trustathanas.absaclone.models.Login
import com.trustathanas.absaclone.models.LoginModel
import com.trustathanas.absaclone.utilities.InjectorUtility
import com.trustathanas.absaclone.viewmodels.LoginViewModel
import com.trustathanas.absaclone.viewmodels.ViewModelProviderFactory
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity
@Inject private constructor(
        private val providerFactory: ViewModelProviderFactory
) : DaggerAppCompatActivity() {


    val tag: String = "LoginActivity"
    fun getLayout(): Int = R.layout.activity_login

    private lateinit var loginViewModel: LoginViewModel

    private lateinit var viewModel: LoginViewModel
    var passcodeSequence: MutableList<Int> = mutableListOf()
    val passcodeLiveData: MutableLiveData<List<Int>> = MutableLiveData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        this.init()
        initializeUi()
    }

    private fun init() {
        loginViewModel = ViewModelProviders.of(this, providerFactory).get(LoginViewModel::class.java)
    }

    private fun initializeUi() {
        val factory = InjectorUtility.provideLoginViewModelFactory()

        viewModel = ViewModelProviders.of(this, factory).get(LoginViewModel::class.java)

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
        getAllUsers()

        passcodeLiveData.observe(this, Observer {
            it?.let {
                if (it.size == 5) {
//                    checkPasscodeValidity()
                    attemptLogin()
                }
            }
        })

    }

    private fun checkPasscodeValidity() {
        var code: String = ""

        passcodeSequence.forEach { code += it.toString() }

//        if (this.getSystemService(Context.NETWORK_STATS_SERVICE) == true){
//            attemptLogin()
//        }

        viewModel.accessCurrentUser().observe(this, Observer {
            it?.let {
                if (it.passCode == code.toInt()) {
                    println("password correct")
                    resetMarker()
                    startActivity(Intent(this, MainActivity::class.java))
                } else {
                    resetMarker()
                    startActivity(Intent(this, PasscodeLockedActivity::class.java))
                }
            }
        })
    }

    private fun attemptLogin() {
        var code: String = ""
        passcodeSequence.forEach { code += it.toString() }

        val loginAtt = viewModel.login(Login(33600929, code.toInt(), 1))

        loginAtt.observe(this, Observer {
            if (it != null) {
                println("Response ${it.response.customer.fullName}")
                println("Response ${it.response.customer.email}")
                println("Response ${it.response.customer.balance}")
                println("Response ${it.response.customer.accountType}")
                resetMarker()
                startActivity(Intent(this, MainActivity::class.java))
            } else {
                resetMarker()
                println("Response: Login failed")
            }
        })
    }


    private fun getAllUsers() {
        viewModel.getAllUsers().observe(this, Observer {
            it?.let { userList ->
                userList.forEach {
                    println("${it.passCode}")
                    println(it.username)
                    println(it.fullname)
                }
            }
        })
    }

    private fun setDefaultUser() {
        viewModel.addUser(LoginModel(username = "trustmub@gmail.com", fullname = "Trust Mubaiwa", passCode = 12345))
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

        val color = if (action == "a") {
            ContextCompat.getDrawable(this, R.drawable.passcode_marker_full)
        } else {
            ContextCompat.getDrawable(this, R.drawable.passcode_markers)
        }

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

    fun onResetPasscodeClicked(view: View) {
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
