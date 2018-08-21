package com.projects.rodrixan.weatherapp.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import com.bumptech.glide.Glide
import com.projects.rodrixan.weatherapp.model.domain.Forecast
import kotlinx.android.synthetic.main.item_forecast.view.*

class ForecastViewHolder(view: View, val clickListener: (Forecast) -> Unit) :
        RecyclerView.ViewHolder(view) {


    fun bindForecast(forecast: Forecast) {
        with(forecast) {
            Glide.with(itemView).load(iconUrl).into(itemView.forecastIcon)
            itemView.forecastDate.text = date
            itemView.forecastDescription.text = description
            itemView.forecastMaxTemp.text = "$high"
            itemView.forecastMinTemp.text = "$low"
            itemView.setOnClickListener { clickListener(this) }
        }
    }
}