package com.projects.rodrixan.weatherapp.model

import java.io.Serializable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Forecast : Serializable {

    @SerializedName("dt")
    @Expose
    var dt: Int? = null
    @SerializedName("main")
    @Expose
    var data: Data? = null
    @SerializedName("weather")
    @Expose
    var weather: List<Weather>? = null
    @SerializedName("clouds")
    @Expose
    var clouds: Clouds? = null
    @SerializedName("wind")
    @Expose
    var wind: Wind? = null
    @SerializedName("sys")
    @Expose
    var sys: Sys? = null
    @SerializedName("dt_txt")
    @Expose
    var dtTxt: String? = null
    @SerializedName("rain")
    @Expose
    var rain: Rain? = null
    @SerializedName("snow")
    @Expose
    var snow: Snow? = null

    /**
     * No args constructor for use in serialization
     *
     */
    constructor() {}

    /**
     *
     * @param clouds
     * @param dt
     * @param wind
     * @param sys
     * @param snow
     * @param dtTxt
     * @param data
     * @param weather
     * @param rain
     */
    constructor(dt: Int?, data: Data, weather: List<Weather>, clouds: Clouds, wind: Wind, sys: Sys, dtTxt: String, rain: Rain, snow: Snow) : super() {
        this.dt = dt
        this.data = data
        this.weather = weather
        this.clouds = clouds
        this.wind = wind
        this.sys = sys
        this.dtTxt = dtTxt
        this.rain = rain
        this.snow = snow
    }

    companion object {
        private const val serialVersionUID = -398815663418333478L
    }

}
