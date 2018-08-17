package com.projects.rodrixan.weatherapp.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import com.projects.rodrixan.weatherapp.model.Forecast

class ForecastListAdapter(val items: List<Forecast>) : RecyclerView.Adapter<ForecastListAdapter
.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(TextView(parent.context))


    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text=items[position].dtTxt!!.toString()
    }


    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
}