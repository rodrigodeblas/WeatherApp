package com.projects.rodrixan.weatherapp.base.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query


@Dao
interface ForecastDataDao {
    @Query("SELECT * from DayForecast")
    fun getAllDayForecast(): List<DayForecast>

    @Insert(onConflict = REPLACE)
    fun updateDayForecast(dayForecast: DayForecast)

    @Insert(onConflict = REPLACE)
    fun updateCityForecast(cityForecast: CityForecast)

    @Insert(onConflict = REPLACE)
    fun insertDayForecasts(dayForecasts: List<DayForecast>)

    @Query("DELETE from DayForecast")
    fun deleteAll()
}