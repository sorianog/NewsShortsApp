package com.sorianog.newsshortsapp.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.sorianog.newsshortsapp.ui.components.LoadingIndicator
import com.sorianog.newsshortsapp.ui.components.NewsList
import com.sorianog.newsshortsapp.ui.viewmodels.NewsViewModel
import com.sorianog.utilities.ResourceState

@Composable
fun HomeScreen(
    newsViewModel: NewsViewModel = hiltViewModel()
) {

    val newsResponse by newsViewModel.news.collectAsState()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.LightGray
    ) {
        when (newsResponse) {
            is ResourceState.Loading -> {
                println("### loading")
                LoadingIndicator()
            }

            is ResourceState.Success -> {
                println("### success")
                val response = (newsResponse as ResourceState.Success).data
//                println("### news: ${response.articles}")
                NewsList(response)
            }

            is ResourceState.Error -> {
                print("### error")
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}