package com.example.movieapp.domain.repository

import com.example.movieapp.domain.model.MovieList
import retrofit2.Response

interface MovieRepository {
    suspend fun getMovieList(movieTitle : String) : Response<MovieList>
}