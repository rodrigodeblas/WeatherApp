package com.projects.rodrixan.weatherapp.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView

class ForecastListAdapter(val items: List<String>) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(TextView(parent.context))


    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }


    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
}