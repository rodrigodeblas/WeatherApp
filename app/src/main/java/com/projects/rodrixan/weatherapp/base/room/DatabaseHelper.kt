package com.projects.rodrixan.weatherapp.base.room

import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import org.jetbrains.anko.doAsync

class DatabaseHelper {


    companion object {
        private val dao: ForecastDataDao by lazy { WeatherDatabase.instance.weatherDataDao() }
        fun getAllDayForecast() {
            doAsync {
                dao.getAllDayForecast()
            }
        }


        fun updateDayForecast(dayForecast: DayForecast) {

        }

        fun deleteAll() {

        }
    }

    class GetAllDayForecastCallback

}