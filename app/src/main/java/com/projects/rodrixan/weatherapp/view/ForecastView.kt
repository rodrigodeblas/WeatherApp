package com.projects.rodrixan.weatherapp.view

import com.projects.rodrixan.weatherapp.model.Forecast

interface ForecastView {

    fun onForecastReceived(results: List<Forecast>)
    fun onError(error: String)
}