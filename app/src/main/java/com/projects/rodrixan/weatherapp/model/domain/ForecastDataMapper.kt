package com.projects.rodrixan.weatherapp.model.domain

import com.projects.rodrixan.weatherapp.base.room.DayForecast
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
        val weather = forecast.weather!![0]
        return ModelForecast(convertDate(forecast.dt!!), weather.description!!,
                forecast.data?.tempMax!!.toInt(), forecast.data?.tempMin!!.toInt(),
                generateIconUrl(weather.icon!!))
    }

    private fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date)
    }

    private fun generateIconUrl(iconCode: String) = "http://openweathermap.org/img/w/$iconCode.png"

    fun convertFromDatabase(forecast: List<DayForecast>): ForecastList {
        return ForecastList("${forecast[0].cityId}", "${forecast[0].cityId}",
                convertForecastListDatabaseToDomain(forecast))
    }


    private fun convertForecastListDatabaseToDomain(list: List<DayForecast>): List<ModelForecast> {
        return list.mapIndexed { index, dayForecast -> convertForecastFromDatabase(dayForecast) }
    }

    private fun convertForecastFromDatabase(dayForecast: DayForecast): ModelForecast {
        with(dayForecast) {
            return ModelForecast(convertDate(date), descpiption, high, low, iconUrl)
        }
    }
}