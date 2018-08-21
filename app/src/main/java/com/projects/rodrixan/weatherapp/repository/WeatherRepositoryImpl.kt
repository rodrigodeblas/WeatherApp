package com.projects.rodrixan.weatherapp.repository

import com.projects.rodrixan.weatherapp.base.rest.WeatherApi
import com.projects.rodrixan.weatherapp.base.rest.WeatherService
import com.projects.rodrixan.weatherapp.base.room.DatabaseHelper
import com.projects.rodrixan.weatherapp.model.ForecastResult
import com.projects.rodrixan.weatherapp.model.domain.ForecastDataMapper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.HttpURLConnection

class WeatherRepositoryImpl : WeatherRepository {

    private val weatherApi: WeatherApi by lazy { WeatherService.create() }
    private val databaseHelper: DatabaseHelper by lazy { DatabaseHelper() }

    override fun getForecastList(interactor: WeatherRepository.ForecastCallback, cityCode: String) {
        val call = weatherApi.forecastByCode(cityCode)
        call.enqueue(object : Callback<ForecastResult> {
            override fun onFailure(call: Call<ForecastResult>, t: Throwable) {
                interactor.onError("Error on call")
            }

            override fun onResponse(call: Call<ForecastResult>, response: Response<ForecastResult>) {
                if (HttpURLConnection.HTTP_OK == response.code()) {
                    interactor.onForecastListReceived(ForecastDataMapper().convertFromDataModel
                    (response.body()!!))
                } else {
                    interactor.onError("There was a problem with the request!")
                }
            }
        })
        databaseHelper.getAllDayForecast {
            interactor.onForecastListReceived(ForecastDataMapper().convertFromDatabase(it))
        }
    }
}