package com.projects.rodrixan.weatherapp.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.projects.rodrixan.weatherapp.R
import com.projects.rodrixan.weatherapp.adapter.ForecastListAdapter
import com.projects.rodrixan.weatherapp.model.ForecastResult
import com.projects.rodrixan.weatherapp.repository.WeatherApi
import com.projects.rodrixan.weatherapp.repository.WeatherService
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    private val weatherApi: WeatherApi = WeatherService.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        forecast_list.layoutManager = LinearLayoutManager(this)
        doAsync {
            val call = weatherApi.forecastByCode("94043")
            call.enqueue(object : Callback<ForecastResult> {
                override fun onFailure(call: Call<ForecastResult>?, t: Throwable?) {
                    Log.e("retrofit", "call failed")
                }

                override fun onResponse(call: Call<ForecastResult>?, response: Response<ForecastResult>?) {
                    Log.d("retrofit", "call success")
                    uiThread {
                        forecast_list.adapter = ForecastListAdapter(response?.body()?.forecastList!!)
                    }
                }

            })
        }

    }
}
