package com.projects.rodrixan.weatherapp.base.room

import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class DatabaseHelper {
    private val dao: ForecastDataDao by lazy { WeatherDatabase.instance.weatherDataDao() }


    fun getAllDayForecast(callback: (List<DayForecast>) -> Unit) {
        doAsync {
            val databaseList = dao.getAllDayForecast()
            uiThread {
                callback.invoke(databaseList)
            }
        }
    }


    fun updateDayForecast(dayForecast: DayForecast) {
        doAsync {
            dao.updateDayForecast(dayForecast)
        }
    }

    fun deleteAll() {
        doAsync {
            dao.deleteAll()
        }
    }


}