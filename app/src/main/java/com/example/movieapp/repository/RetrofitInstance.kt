package com.example.movieapp.repository

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private const val baseUrl = "https://www.omdbapi.com/"

    val api : MovieApi by lazy {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieApi::class.java)

    }
}