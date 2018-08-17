package com.projects.rodrixan.weatherapp.model

import java.io.Serializable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Snow : Serializable {

    @SerializedName("3h")
    @Expose
    var volume3h:Double? = null

    /**
     * No args constructor for use in serialization
     *
     */
    constructor() {}

    /**
     *
     * @param _3h
     */
    constructor(_3h: Double?) : super() {
        this.volume3h = _3h
    }

    companion object {
        private const val serialVersionUID = 5600092648211246429L
    }

}
