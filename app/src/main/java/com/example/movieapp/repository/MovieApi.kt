package com.example.movieapp.repository

import com.example.movieapp.model.MovieList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    /**
     * Gets the list of movies with the specified title
     */
    @GET("?type=movie")
    suspend fun getMovies(@Query("apiKey") apiKey : String, @Query("s") title :String) : Response<MovieList>

}
