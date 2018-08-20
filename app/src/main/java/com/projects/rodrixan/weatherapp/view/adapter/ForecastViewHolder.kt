package com.projects.rodrixan.weatherapp.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.projects.rodrixan.weatherapp.R
import com.projects.rodrixan.weatherapp.model.domain.Forecast
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find

class ForecastViewHolder(view: View, val clickListener: (Forecast) -> Unit) :
        RecyclerView.ViewHolder(view) {

    private val iconView = view.find<ImageView>(R.id.item_forecast_icon)
    private val dateView = view.find<TextView>(R.id.item_forecast_date)
    private val descriptionView = view.find<TextView>(R.id.item_forecast_description)
    private val maxTemperatureView = view.find<TextView>(R.id.item_forecast_max_temp)
    private val minTemperatureView = view.find<TextView>(R.id.item_forecast_min_temp)

    fun bindForecast(forecast: Forecast) {
        with(forecast) {
            Picasso.get().load(iconUrl).into(iconView)
            dateView.text = date
            descriptionView.text = description
            maxTemperatureView.text = "$high"
            minTemperatureView.text = "$low"
            itemView.setOnClickListener { clickListener(this) }
        }
    }
}