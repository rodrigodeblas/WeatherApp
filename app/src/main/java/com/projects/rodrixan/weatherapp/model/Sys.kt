package com.projects.rodrixan.weatherapp.model

import java.io.Serializable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Sys : Serializable {

    @SerializedName("pod")
    @Expose
    var pod: String? = null

    /**
     * No args constructor for use in serialization
     *
     */
    constructor() {}

    /**
     *
     * @param pod
     */
    constructor(pod: String) : super() {
        this.pod = pod
    }

    companion object {
        private const val serialVersionUID = 5908483673990022030L
    }

}
