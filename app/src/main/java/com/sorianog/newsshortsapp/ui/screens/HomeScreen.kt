package com.sorianog.newsshortsapp.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sorianog.newsshortsapp.ui.components.LoadingIndicator
import com.sorianog.newsshortsapp.ui.components.NewsList
import com.sorianog.newsshortsapp.ui.components.NewsRowComponent
import com.sorianog.newsshortsapp.ui.viewmodels.NewsViewModel
import com.sorianog.utilities.ResourceState

@Composable
fun HomeScreen(
    newsViewModel: NewsViewModel = hiltViewModel()
) {

    val newsResponse by newsViewModel.news.collectAsState()

    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) {
        100
    }

    VerticalPager(
        state = pagerState,
        modifier = Modifier.fillMaxSize(),
        pageSize = PageSize.Fill,
        pageSpacing = 8.dp
    ) { page: Int ->

        when (newsResponse) {
            is ResourceState.Loading -> {
                println("### loading")
                LoadingIndicator()
            }

            is ResourceState.Success -> {
                println("### success")
                val response = (newsResponse as ResourceState.Success).data

                val articles = response.articles
                if (articles.isNotEmpty()) {
                    NewsRowComponent(page, response.articles[page])
                }
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