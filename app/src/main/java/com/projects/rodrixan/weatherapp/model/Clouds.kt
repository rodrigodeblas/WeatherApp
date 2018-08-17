package com.projects.rodrixan.weatherapp.model

import java.io.Serializable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Clouds : Serializable {

    @SerializedName("all")
    @Expose
    var all: Int? = null

    /**
     * No args constructor for use in serialization
     *
     */
    constructor() {}

    /**
     *
     * @param all
     */
    constructor(all: Int?) : super() {
        this.all = all
    }

    companion object {
        private const val serialVersionUID = -2991513801359587537L
    }

}
