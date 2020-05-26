package com.njm.movies.data.retrofit

import com.njm.movies.data.service.ApiMovieService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitMovieClient(){

    fun getRetrofitService(): ApiMovieService{
        val httpLoggingInterceptor: HttpLoggingInterceptor = HttpLoggingInterceptor()
        val okHttpClient: OkHttpClient.Builder = OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor)
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("algo")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient.build())
            .build()

        val apiMovieService: ApiMovieService = retrofit.create(ApiMovieService::class.java)

        return apiMovieService
    }


}