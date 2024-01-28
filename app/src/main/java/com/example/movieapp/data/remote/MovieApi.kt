package com.example.movieapp.data.remote

import com.example.movieapp.BuildConfig
import com.example.movieapp.domain.model.MovieList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    /**
     * Gets the list of movies with the specified title
     */
    @GET("?type=movie")
    suspend fun getMovies(@Query("s") title :String,
                          @Query("apiKey") apiKey : String) : Response<MovieList>

}
