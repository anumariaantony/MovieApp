package com.example.movieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movieapp.ui.theme.MovieAppTheme
import com.example.movieapp.ui.screen.MovieListScreen
import com.example.movieapp.ui.screen.MovieSearchScreen
import com.example.movieapp.viewmodel.MovieViewModel

class MainActivity : ComponentActivity() {

    //Omdb Api key
    private val apiKeyValue = "c6f8b367"
    private lateinit var movieViewModel: MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        movieViewModel = ViewModelProvider (this).get(MovieViewModel::class.java)

        //movieViewModel = MovieViewModel()

        setContent {
            MovieAppTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(
                    //Top bar showing the name of the App
                    topBar = {
                        TopAppBar(
                            backgroundColor =MaterialTheme.colors.primary,
                            title = { Text(stringResource(R.string.app_name)) }
                        )
                    }
                ) {
                    ComposeNavigation(apiKeyValue,movieViewModel)
                }
            }
        }
    }
}


/**
 * Composable for navigating from movie search screen to movie list screen
 */
@Composable
fun ComposeNavigation(apiKeyValue: String, movieViewModel : MovieViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "movieSearchScreen") {
        composable("movieSearchScreen") {
            MovieSearchScreen(apiKeyValue,movieViewModel, navController)
        }
        composable("movieListScreen") {
            MovieListScreen(movieViewModel)
        }
    }
}
