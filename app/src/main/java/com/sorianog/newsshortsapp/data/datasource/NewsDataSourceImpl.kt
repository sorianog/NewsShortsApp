package com.sorianog.newsshortsapp.data.datasource

import com.sorianog.newsshortsapp.data.api.NewsApiService
import com.sorianog.newsshortsapp.data.entity.TopHeadlinesResponse
import retrofit2.Response
import javax.inject.Inject

class NewsDataSourceImpl @Inject constructor(
    private val apiService: NewsApiService
) : NewsDataSource {

    override suspend fun getTopNewsHeadlines(country: String): Response<TopHeadlinesResponse> {
        return apiService.getTopNewsHeadlines(country)
    }
}