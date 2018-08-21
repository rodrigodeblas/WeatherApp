package com.projects.rodrixan.weatherapp.base.room

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.*

@Entity(tableName = "CityForecast")
data class CityForecast(
        @PrimaryKey(autoGenerate = true) val id: Long?,
        @ColumnInfo(name = "city") val city: String,
        @ColumnInfo(name = "country") var country: String
)


@Entity(tableName = "DayForecast")
data class DayForecast(
        @PrimaryKey(autoGenerate = true) val id: Long?,
        @ColumnInfo(name = "date") val city: Date,
        @ColumnInfo(name = "description") var descpiption: String,
        @ColumnInfo(name = "high") var high: Int,
        @ColumnInfo(name = "low") var low: Int,
        @ColumnInfo(name = "iconUrl") var iconUrl: String,
        @ColumnInfo(name = "cityId") var cityId: Long
)
