package com.njm.movies.data.retrofit

import com.njm.movies.data.service.ApiMovieService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {  //object seria como un singleton, no se puede instanciar RetrofitService, se llama a la Clase y a la fun que posee, algo asi como un static

    private val httpLoggingInterceptor: HttpLoggingInterceptor = HttpLoggingInterceptor()
    private val okHttpClient: OkHttpClient.Builder = OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor)
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://swapi.dev/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(okHttpClient.build())
        .build()
        .create(ApiMovieService::class.java)//instancia del cliente para usar la funcion de la interface

    fun getInstanceRetrofit(): ApiMovieService {
        return retrofit
    }
}