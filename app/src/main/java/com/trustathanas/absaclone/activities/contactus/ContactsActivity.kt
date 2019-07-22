package com.trustathanas.absaclone.activities.contactus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.trustathanas.absaclone.R
import com.trustathanas.absaclone.activities.BaseActivity
import kotlinx.android.synthetic.main.activity_contacts.*

class ContactsActivity : BaseActivity() {

    override val tag: String
        get() = "ContactsActivity"

    override fun getLayout(): Int = R.layout.activity_contacts

    lateinit var tabLayout: TabLayout
    lateinit var tabLayoutManaget: androidx.recyclerview.widget.RecyclerView.LayoutManager
    private val contactsFragment: ContactsFragment = ContactsFragment()
    lateinit var fragmentTransaction: androidx.fragment.app.FragmentTransaction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())

        val fragmentManager = supportFragmentManager
        vp_contracts.adapter = ContactsViewPagerAdapter(fragmentManager)


    }
}
