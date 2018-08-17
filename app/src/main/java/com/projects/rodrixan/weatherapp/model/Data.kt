package com.projects.rodrixan.weatherapp.model

import java.io.Serializable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Data : Serializable {

    @SerializedName("temp")
    @Expose
    var temp: Double? = null
    @SerializedName("temp_min")
    @Expose
    var tempMin: Double? = null
    @SerializedName("temp_max")
    @Expose
    var tempMax: Double? = null
    @SerializedName("pressure")
    @Expose
    var pressure: Double? = null
    @SerializedName("sea_level")
    @Expose
    var seaLevel: Double? = null
    @SerializedName("grnd_level")
    @Expose
    var grndLevel: Double? = null
    @SerializedName("humidity")
    @Expose
    var humidity: Int? = null
    @SerializedName("temp_kf")
    @Expose
    var tempKf: Double? = null

    /**
     * No args constructor for use in serialization
     *
     */
    constructor() {}

    /**
     *
     * @param seaLevel
     * @param humidity
     * @param pressure
     * @param grndLevel
     * @param tempMax
     * @param temp
     * @param tempKf
     * @param tempMin
     */
    constructor(temp: Double?, tempMin: Double?, tempMax: Double?, pressure: Double?, seaLevel: Double?, grndLevel: Double?, humidity: Int?, tempKf: Double?) : super() {
        this.temp = temp
        this.tempMin = tempMin
        this.tempMax = tempMax
        this.pressure = pressure
        this.seaLevel = seaLevel
        this.grndLevel = grndLevel
        this.humidity = humidity
        this.tempKf = tempKf
    }

    companion object {
        private const val serialVersionUID = 4491730500675213058L
    }

}
