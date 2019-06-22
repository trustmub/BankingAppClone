package com.trustathanas.absaclone.activities.home.home


import android.annotation.SuppressLint
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.graphics.drawable.Drawable
import android.media.Image
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.RequestManager

import com.trustathanas.absaclone.R
import com.trustathanas.absaclone.activities.BaseFragment
import com.trustathanas.absaclone.viewmodels.ViewModelProviderFactory
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import javax.inject.Inject


class HomeFragment : BaseFragment() {

    override val logTag: String
        get() = "Home Fragment"

    override fun getLayout(): Int = R.layout.fragment_home

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    @Inject
    lateinit var requestManager: RequestManager

    @Inject
    lateinit var userAvatar: Drawable

    @Inject
    lateinit var adapter: ServiceListRecyclerAdapter

    lateinit var viewModel: HomeViewModel
    lateinit var serviceListRecyclerView: RecyclerView


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayout(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this, providerFactory).get(HomeViewModel::class.java)

        serviceListRecyclerView = activity!!.findViewById(R.id.rv_service_list)

        this.setRecyclerView()
        this.setUserAvatar()
        this.subscribeObservers()
    }

    private fun setRecyclerView() {
        serviceListRecyclerView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        serviceListRecyclerView.adapter = adapter
    }

    private fun setUserAvatar() {
        requestManager
                .load(userAvatar)
                .into(activity!!.findViewById(R.id.img_user_thumbnail))
    }

    @SuppressLint("SetTextI18n")
    private fun subscribeObservers() {
        viewModel.getUserInfo().removeObservers(viewLifecycleOwner)
        viewModel.getUserInfo().observe(viewLifecycleOwner, Observer { authResource ->
            authResource?.let { data ->
                data.data?.let {
                    tv_full_name.text = it.customer.fullName
                    tv_account_type_label.text = "Personal Bank account"

                    tv_card_balance.text = it.customer.balance.toString()
                    tv_card_account_type.text = it.customer.accountType + " " + getString(R.string.account)
                    tv_card_account_number.text = it.customer.accountNumber.toString()
                }
            }
        })
    }


}
