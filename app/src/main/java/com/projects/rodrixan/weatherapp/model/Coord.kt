package com.projects.rodrixan.weatherapp.model

import java.io.Serializable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Coord : Serializable {

    @SerializedName("lat")
    @Expose
    var lat: Double? = null
    @SerializedName("lon")
    @Expose
    var lon: Double? = null

    /**
     * No args constructor for use in serialization
     *
     */
    constructor() {}

    /**
     *
     * @param lon
     * @param lat
     */
    constructor(lat: Double?, lon: Double?) : super() {
        this.lat = lat
        this.lon = lon
    }

    companion object {
        private const val serialVersionUID = 5080989826602420042L
    }

}
