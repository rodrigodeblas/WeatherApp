package com.projects.rodrixan.weatherapp.repository

import com.projects.rodrixan.weatherapp.model.domain.ForecastList

interface WeatherRepository {

    fun getForecastList(interactor: ForecastCallback, cityCode: String)

    interface ForecastCallback {
        fun onForecastListReceived(results: ForecastList)
        fun onError(error: String)
    }
}