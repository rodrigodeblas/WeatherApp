package com.projects.rodrixan.weatherapp.repository

import com.projects.rodrixan.weatherapp.model.ForecastResult

interface WeatherRepository {

    fun getForecastList(interactor: ForecastCallback, cityCode: String)

    interface ForecastCallback {
        fun onForecastListReceived(results: ForecastResult)
        fun onError(error: String)
    }
}