package com.example.movieapp.domain.model

import com.example.movieapp.domain.model.Movie

data class MovieList(
    val Search: List<Movie>,
    val Response: String,
    val totalResults: String
)