package com.example.movieapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.movieapp.model.Movie
import com.example.movieapp.viewmodel.MovieViewModel

/**
 * Displays each movie list in rows
 */
@Composable
fun MovieListScreen(movieViewModel: MovieViewModel) {
    val movies by movieViewModel.movies.collectAsState()
    Column {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .weight(1f)
        ) {
            if (!movies.isNullOrEmpty()) {
                items(movies) {
                    MovieList(it)
                }
            }
        }
    }
}

/**
 * Displays each movie details
 */
@Composable
fun MovieList(movie: Movie) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 8.dp,
                vertical = 8.dp
            ),
        shape = RoundedCornerShape(16.dp),
        elevation = 8.dp
    ) {
        Row {
            MoviePoster(movie)
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
            ) {
                Text(text = movie.Title, style = MaterialTheme.typography.h6)
                Text(text = movie.Year, style = MaterialTheme.typography.h6)
            }
        }
    }
}

/**
 * Displays movie poster
 */
@Composable
fun MoviePoster(movie: Movie) {
    Image(
        painter = rememberAsyncImagePainter(movie.Poster),
        contentDescription = movie.Title,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(8.dp)
            .size(84.dp)
            .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
    )
}