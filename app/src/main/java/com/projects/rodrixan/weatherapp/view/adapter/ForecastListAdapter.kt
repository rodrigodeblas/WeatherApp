package com.projects.rodrixan.weatherapp.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.projects.rodrixan.weatherapp.R
import com.projects.rodrixan.weatherapp.model.domain.Forecast
import com.projects.rodrixan.weatherapp.model.domain.ForecastList
import com.projects.rodrixan.weatherapp.view.utils.ctx

class ForecastListAdapter(val weekForecast: ForecastList, val clickListener: (Forecast) -> Unit)
    : RecyclerView.Adapter<ForecastViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        val view = LayoutInflater.from(parent.ctx).inflate(R.layout.item_forecast, parent, false)

        return ForecastViewHolder(view, clickListener)
    }


    override fun getItemCount(): Int = weekForecast.size

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        holder.bindForecast(weekForecast[position])
    }

}