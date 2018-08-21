package com.projects.rodrixan.weatherapp.base

import android.app.Application
import com.projects.rodrixan.weatherapp.view.utils.DelegatesExt

class WeatherApp : Application() {

    companion object {
        var instance: WeatherApp by DelegatesExt.notNullSingleValue()
    }


    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}