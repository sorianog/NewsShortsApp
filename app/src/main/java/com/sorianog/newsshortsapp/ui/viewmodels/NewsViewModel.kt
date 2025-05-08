package com.sorianog.newsshortsapp.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sorianog.newsshortsapp.data.entity.TopHeadlinesResponse
import com.sorianog.newsshortsapp.repository.NewsRepository
import com.sorianog.utilities.ResourceState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsRepository: NewsRepository
) : ViewModel() {

    private val _news: MutableStateFlow<ResourceState<TopHeadlinesResponse>> =
        MutableStateFlow(ResourceState.Loading())
    val news: StateFlow<ResourceState<TopHeadlinesResponse>> = _news

    init {
        getTopNews("us")
    }

    private fun getTopNews(country: String) {
        viewModelScope.launch(Dispatchers.IO) {
            newsRepository.getTopNewsHeadlines(country).collectLatest { newsResponse ->
                _news.update { newsResponse }
            }
        }
    }
}