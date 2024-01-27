package com.example.movieapp.presentation.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.movieapp.presentation.viewmodel.MovieViewModel

/**
 * Composable for the movie search screen with text field and search button
 */
@Composable
fun MovieSearchScreen(apiKeyValue : String, movieViewModel: MovieViewModel, navController: NavController) {

    var textFieldState = remember {
        mutableStateOf("")
    }

    Column( horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()) {

        // Text field for entering the movie title
        TextField(
            value = textFieldState.value,
            label = { Text(text = "Enter the movie title") },
            onValueChange = { textFieldState.value = it },
            singleLine = true,
        )

        Spacer(modifier = Modifier.padding(10.dp))

        // Search button
        Button(
            onClick = {
            var movieTitle = textFieldState.value
            //Gets the list of movies
            movieViewModel.getMoviesList(apiKeyValue, movieTitle)
            //Navigate to movie list screen
            navController.navigate("movieListScreen") }
        ) {
            Text( text = "Search" )
        }
    }
}