package com.projects.rodrixan.weatherapp.model

import java.io.Serializable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ForecastResult : Serializable {

    @SerializedName("cod")
    @Expose
    var cod: String? = null
    @SerializedName("message")
    @Expose
    var message: Double? = null
    @SerializedName("cnt")
    @Expose
    var cnt: Int? = null
    @SerializedName("list")
    @Expose
    var forecastList: List<Forecast>? = null
    @SerializedName("city")
    @Expose
    var city: City? = null

    /**
     * No args constructor for use in serialization
     *
     */
    constructor() {}

    /**
     *
     * @param message
     * @param cnt
     * @param cod
     * @param forecastList
     * @param city
     */
    constructor(cod: String, message: Double?, cnt: Int?, forecastList: List<Forecast>, city: City) : super() {
        this.cod = cod
        this.message = message
        this.cnt = cnt
        this.forecastList = forecastList
        this.city = city
    }

    companion object {
        private const val serialVersionUID = 6052221064289622104L
    }

}
