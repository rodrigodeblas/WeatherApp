package com.projects.rodrixan.weatherapp.base.rest

import com.projects.rodrixan.weatherapp.model.ForecastResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("forecast?")
    fun forecastByCode(@Query("q") code: String): Call<ForecastResult>
}