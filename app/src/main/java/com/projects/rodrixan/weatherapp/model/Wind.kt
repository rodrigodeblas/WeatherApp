package com.projects.rodrixan.weatherapp.model

import java.io.Serializable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Wind : Serializable {

    @SerializedName("speed")
    @Expose
    var speed: Double? = null
    @SerializedName("deg")
    @Expose
    var deg: Double? = null

    /**
     * No args constructor for use in serialization
     *
     */
    constructor() {}

    /**
     *
     * @param speed
     * @param deg
     */
    constructor(speed: Double?, deg: Double?) : super() {
        this.speed = speed
        this.deg = deg
    }

    companion object {
        private const val serialVersionUID = 7393226285466575971L
    }

}
