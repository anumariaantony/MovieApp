package com.example.movieapp.model

data class MovieList(
    val Search: List<Movie>,
    val Response: String,
    val totalResults: String
)