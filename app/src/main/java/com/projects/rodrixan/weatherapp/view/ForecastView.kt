package com.projects.rodrixan.weatherapp.view

import com.projects.rodrixan.weatherapp.model.domain.ForecastList

interface ForecastView {

    fun onForecastReceived(results: ForecastList)
    fun onError(error: String)
}