package com.projects.rodrixan.weatherapp.interactor

import com.projects.rodrixan.weatherapp.view.ForecastView

interface ForecastPresenter {
    fun init(view: ForecastView)
    fun getForecastByCity(code:String)
}