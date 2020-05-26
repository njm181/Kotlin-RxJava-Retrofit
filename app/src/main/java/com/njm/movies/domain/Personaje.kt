package com.njm.movies.domain

import com.google.gson.annotations.SerializedName

data class Personaje (

    @SerializedName("birth_year")
    var birthYear: String,

    @SerializedName("eye_color")
    var eyeColor: String,

    @SerializedName("films")
    var films: List<String>,

    @SerializedName("height")
    var height: String,

    @SerializedName("name")
    var name: String

)
