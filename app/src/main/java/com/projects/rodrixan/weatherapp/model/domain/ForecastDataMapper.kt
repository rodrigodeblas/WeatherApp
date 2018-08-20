package com.projects.rodrixan.weatherapp.model.domain

import com.projects.rodrixan.weatherapp.model.Forecast
import com.projects.rodrixan.weatherapp.model.ForecastResult
import java.text.DateFormat
import java.util.*
import java.util.concurrent.TimeUnit
import com.projects.rodrixan.weatherapp.model.domain.Forecast as ModelForecast

class ForecastDataMapper {

    fun convertFromDataModel(forecast: ForecastResult): ForecastList {
        return ForecastList(forecast.city?.name!!, forecast.city?.country!!,
                convertForecastListToDomain(forecast.forecastList!!))
    }

    private fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast> {
        return list.mapIndexed { i, forecast ->
            val dt = Calendar.getInstance().timeInMillis + TimeUnit.DAYS.toMillis(i.toLong())
            convertForecastItemToDomain(forecast.copy(dt = dt))
        }
    }

    private fun convertForecastItemToDomain(forecast: Forecast): ModelForecast {
        return ModelForecast(convertDate(forecast.dt!!), forecast.weather!![0].description!!,
                forecast.data?.tempMax!!.toInt(), forecast.data?.tempMin!!.toInt())
    }

    private fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date)
    }
}