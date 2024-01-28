package com.example.movieapp.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.domain.model.Movie
import com.example.movieapp.domain.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

const val  TAG = "MovieViewModel"

@HiltViewModel
class MovieViewModel @Inject constructor (private val movieRepository: MovieRepository) : ViewModel() {

    //List of movies in the Movie list screen
    private val _movies = MutableStateFlow(listOf<Movie>())
    val movies: StateFlow<List<Movie>> get() = _movies


    /**
     * Gets the list of movies with the specified string using retrofit
     */
    fun getMoviesList(movieTitle : String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = movieRepository.getMovieList(movieTitle)
            withContext(Dispatchers.Main) {
                if (response.isSuccessful && response.body() != null) {
                    _movies.value = response.body()!!.Search
                    Log.d(TAG, "Response is Successful")
                } else {
                    Log.e(TAG, "Response not Successfull")
                }
            }

        }
    }
}