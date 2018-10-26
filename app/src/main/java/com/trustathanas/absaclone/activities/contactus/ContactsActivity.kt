package com.trustathanas.absaclone.activities.contactus

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.FragmentTransaction
import android.support.v7.widget.RecyclerView
import com.trustathanas.absaclone.R
import com.trustathanas.absaclone.activities.BaseActivity
import kotlinx.android.synthetic.main.activity_contacts.*

class ContactsActivity : BaseActivity() {

    override val tag: String
        get() = "ContactsActivity"

    override fun getLayout(): Int = R.layout.activity_contacts

    lateinit var tabLayout: TabLayout
    lateinit var tabLayoutManaget: RecyclerView.LayoutManager
    private val contactsFragment: ContactsFragment = ContactsFragment()
    lateinit var fragmentTransaction: FragmentTransaction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())

        val fragmentManager = supportFragmentManager
        vp_contracts.adapter = ContactsViewPagerAdapter(fragmentManager)


    }
}
