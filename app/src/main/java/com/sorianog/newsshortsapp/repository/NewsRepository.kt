package com.sorianog.newsshortsapp.repository

import com.sorianog.newsshortsapp.data.datasource.NewsDataSource
import com.sorianog.newsshortsapp.data.entity.TopHeadlinesResponse
import retrofit2.Response
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val newsDataSource: NewsDataSource
) {

    suspend fun getTopNewsHeadlines(country: String): Response<TopHeadlinesResponse> {
        return newsDataSource.getTopNewsHeadlines(country)
    }
}