package com.example.movieapp.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.model.Movie
import com.example.movieapp.repository.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

const val  TAG = "MovieViewModel"

class MovieViewModel : ViewModel() {

    //List of movies in the Movie list screen
    private val _movies = MutableStateFlow(listOf<Movie>())
    val movies: StateFlow<List<Movie>> get() = _movies


    /**
     * Gets the list of movies with the specified string using retrofit
     */
    fun getMoviesList(apiKey : String, movieTitle : String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = RetrofitInstance.api.getMovies(apiKey, movieTitle)
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