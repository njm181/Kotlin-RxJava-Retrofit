package com.njm.movies.domain

import com.google.gson.annotations.SerializedName

data class Datos (@SerializedName("count") var count: String, @SerializedName("next") var next: String, @SerializedName("results") var results: List<Personaje>)
