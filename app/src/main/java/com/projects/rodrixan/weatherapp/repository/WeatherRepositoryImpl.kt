package com.projects.rodrixan.weatherapp.repository

import android.util.Log
import com.projects.rodrixan.weatherapp.adapter.ForecastListAdapter
import com.projects.rodrixan.weatherapp.model.ForecastResult
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.HttpURLConnection

class WeatherRepositoryImpl : WeatherRepository {

    private val weatherApi: WeatherApi by lazy { WeatherService.create() }

    override fun getForecastList(interactor: WeatherRepository.ForecastCallback, cityCode: String) {
        val call = weatherApi?.forecastByCode(cityCode)
        call.enqueue(object : Callback<ForecastResult> {
            override fun onFailure(call: Call<ForecastResult>?, t: Throwable?) {
                interactor.onError("Error on call")
            }

            override fun onResponse(call: Call<ForecastResult>?, response: Response<ForecastResult>?) {
                if (HttpURLConnection.HTTP_OK == response?.code()) {
                    interactor.onForecastListReceived(response?.body()!!)
                } else {
                    interactor.onError("There was a problem with the request!")
                }
            }
        })
    }
}