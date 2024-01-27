package com.example.movieapp

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.movieapp.presentation.ui.MainActivity
import org.junit.Rule
import org.junit.Test

class MovieSearchTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule(MainActivity::class.java)

    @Test
    fun enter_movie_title_field_displayed() {
        composeTestRule.onNodeWithText("Enter the movie title").assertIsDisplayed()
    }

    @Test
    fun search_button_displayed_and_clickable() {
        composeTestRule.onNodeWithText("Search").assertIsDisplayed()
        composeTestRule.onNodeWithText("Search").performClick()
    }

}