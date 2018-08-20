package com.projects.rodrixan.weatherapp.view.adapter

import com.projects.rodrixan.weatherapp.model.domain.Forecast

interface OnForecastSelectedListener {
    operator fun invoke(selected: Forecast)
}