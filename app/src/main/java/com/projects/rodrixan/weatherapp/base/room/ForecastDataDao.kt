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

    @Query("DELETE from DayForecast")
    fun deleteAll()
}