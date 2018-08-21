package com.projects.rodrixan.weatherapp.base.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import com.projects.rodrixan.weatherapp.base.WeatherApp

@Database(entities = [CityForecast::class, DayForecast::class], version = 1)
abstract class WeatherDatabase : RoomDatabase() {

    abstract fun weatherDataDao(): ForecastDataDao

    companion object {
        val DB_NAME = "weather.db"

        val instance: WeatherDatabase by lazy {
            synchronized(WeatherDatabase::class) {
                Room.databaseBuilder(WeatherApp.instance.applicationContext,
                        WeatherDatabase::class.java, DB_NAME)
                        .fallbackToDestructiveMigration().build()
            }
        }
    }

}