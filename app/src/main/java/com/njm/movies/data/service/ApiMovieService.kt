package com.njm.movies.data.service

import com.njm.movies.domain.Datos
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET

interface ApiMovieService {

    @GET("people")
    fun getMovies(): Observable<Datos>
}