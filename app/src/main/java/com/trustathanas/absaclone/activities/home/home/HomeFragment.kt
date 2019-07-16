package com.trustathanas.absaclone.activities.home.home


import android.annotation.SuppressLint
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.databinding.library.baseAdapters.BR.viewModelData
import com.bumptech.glide.RequestManager
import com.trustathanas.absaclone.R
import com.trustathanas.absaclone.activities.BaseFragment
import com.trustathanas.absaclone.viewmodels.ViewModelProviderFactory
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject


class HomeFragment : BaseFragment() {

    override val logTag: String
        get() = "Home Fragment"

    override fun getLayout(): Int = R.layout.fragment_home

    lateinit var binding: ViewDataBinding

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
        binding = DataBindingUtil.inflate<ViewDataBinding>(inflater, R.layout.fragment_home, container, false) as ViewDataBinding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this, providerFactory).get(HomeViewModel::class.java)
        binding.setVariable(viewModelData, viewModel)

        viewModel.getUserInformation()
        serviceListRecyclerView = activity!!.findViewById(R.id.rv_service_list)

        this.setRecyclerView()
        this.setUserAvatar()
        this.setViewValues()
    }

    private fun setViewValues() {
        tv_card_account_type.text = viewModel.accountType.value + " " + getString(R.string.account)
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


}
