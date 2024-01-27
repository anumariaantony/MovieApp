package com.example.movieapp.domain.repository

import com.example.movieapp.domain.model.MovieList
import retrofit2.Response

interface MovieRepository {
    suspend fun getMovies(apiKey: String, movieTitle : String) : Response<MovieList>
}