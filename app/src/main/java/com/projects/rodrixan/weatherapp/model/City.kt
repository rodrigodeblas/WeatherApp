package com.projects.rodrixan.weatherapp.model

import java.io.Serializable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class City : Serializable {

    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("coord")
    @Expose
    var coord: Coord? = null
    @SerializedName("country")
    @Expose
    var country: String? = null

    /**
     * No args constructor for use in serialization
     *
     */
    constructor() {}

    /**
     *
     * @param coord
     * @param id
     * @param name
     * @param country
     */
    constructor(id: Int?, name: String, coord: Coord, country: String) : super() {
        this.id = id
        this.name = name
        this.coord = coord
        this.country = country
    }

    companion object {
        private const val serialVersionUID = 6307614328883428937L
    }

}
