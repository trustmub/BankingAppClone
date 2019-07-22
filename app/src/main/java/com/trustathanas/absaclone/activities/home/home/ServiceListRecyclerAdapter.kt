package com.trustathanas.absaclone.activities.home.home

import android.graphics.drawable.Drawable
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.trustathanas.absaclone.R

class ServiceListRecyclerAdapter : androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder>() {

    val serviceList: List<String> = listOf<String>("Pay", "Transfer", "CashSend", "Buy Airtime", "Buy Electricity")
    val serviceIcons: List<Int> = listOf<Int>(
            R.drawable.ic_account_balance_wallet_black_24dp,
            R.drawable.ic_transfer_24dp,
            R.drawable.ic_cash_send_24dp,
            R.drawable.ic_buy_airtime_24dp,
            R.drawable.ic_buy_electricity_24dp
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): androidx.recyclerview.widget.RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_service_list_item, parent, false)
        return ServiceViewHolder(view)
    }

    override fun getItemCount(): Int {
        return serviceList.size
    }

    override fun onBindViewHolder(holder: androidx.recyclerview.widget.RecyclerView.ViewHolder, position: Int) {
        (holder as ServiceViewHolder).bind(serviceList.get(position), serviceIcons.get(position))
    }

    inner class ServiceViewHolder(val itemview: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemview) {
        var title: TextView = itemview.findViewById(R.id.tv_service_title)
        var fabImage: FloatingActionButton = itemview.findViewById(R.id.fab_service_item)

        fun bind(service: String, drawable: Int) {
            title.text = service
            fabImage.setImageResource(drawable)
        }

    }
}