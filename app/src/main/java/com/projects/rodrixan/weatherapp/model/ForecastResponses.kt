package com.projects.rodrixan.weatherapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ForecastResult(@SerializedName("cod") var cod: String? = null,
                          @SerializedName("message") var message: Double? = null,
                          @SerializedName("cnt") var cnt: Int? = null,
                          @SerializedName("list") var forecastList: List<Forecast>? = null,
                          @SerializedName("city") var city: City? = null) : Serializable

data class Forecast(@SerializedName("dt") var dt: Long? = null,
                    @SerializedName("main") var data: Data? = null,
                    @SerializedName("weather") var weather: List<Weather>? = null,
                    @SerializedName("clouds") var clouds: Clouds? = null,
                    @SerializedName("wind") var wind: Wind? = null,
                    @SerializedName("sys") var sys: Sys? = null,
                    @SerializedName("dt_txt") var dtTxt: String? = null,
                    @SerializedName("rain") var rain: Rain? = null,
                    @SerializedName("snow") var snow: Snow? = null) : Serializable


data class City(@SerializedName("id") var id: Int? = null,
                @SerializedName("name") var name: String? = null,
                @SerializedName("coord") var coord: Coord? = null,
                @SerializedName("country") var country: String? = null) : Serializable

data class Data(@SerializedName("temp") var temp: Double? = null,
                @SerializedName("temp_min") var tempMin: Double? = null,
                @SerializedName("temp_max") var tempMax: Double? = null,
                @SerializedName("pressure") var pressure: Double? = null,
                @SerializedName("sea_level") var seaLevel: Double? = null,
                @SerializedName("grnd_level") var grndLevel: Double? = null,
                @SerializedName("humidity") var humidity: Int? = null,
                @SerializedName("temp_kf") var tempKf: Double? = null) : Serializable


data class Weather(@SerializedName("id") var id: Int? = null,
                   @SerializedName("main") var main: String? = null,
                   @SerializedName("description") var description: String? = null,
                   @SerializedName("icon") var icon: String? = null) : Serializable

data class Clouds(@SerializedName("all") var all: Int? = null) : Serializable

data class Coord(@SerializedName("lat") var lat: Double? = null,
                 @SerializedName("lon") var lon: Double? = null) : Serializable

data class Rain(@SerializedName("3h") var volume3h: Double? = null) : Serializable

data class Snow(@SerializedName("3h") var volume3h: Double? = null) : Serializable

data class Sys(@SerializedName("pod") var pod: String? = null) : Serializable

data class Wind(@SerializedName("speed") var speed: Double? = null,
                @SerializedName("deg") var deg: Double? = null) : Serializable
    