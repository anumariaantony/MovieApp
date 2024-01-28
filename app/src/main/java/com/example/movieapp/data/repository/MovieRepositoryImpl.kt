package com.example.movieapp.data.repository

import com.example.movieapp.BuildConfig
import com.example.movieapp.domain.model.MovieList
import com.example.movieapp.data.remote.MovieApi
import com.example.movieapp.domain.repository.MovieRepository
import retrofit2.Response

class MovieRepositoryImpl(private val api : MovieApi) : MovieRepository {
    override suspend fun getMovieList(movieTitle: String) : Response<MovieList> {
        return api.getMovies(movieTitle, BuildConfig.API_KEY)
    }

}