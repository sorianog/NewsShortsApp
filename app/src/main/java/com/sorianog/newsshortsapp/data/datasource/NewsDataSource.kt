package com.sorianog.newsshortsapp.data.datasource

import com.sorianog.newsshortsapp.data.entity.TopHeadlinesResponse
import retrofit2.Response

interface NewsDataSource {

    suspend fun getTopNewsHeadlines(country: String) : Response<TopHeadlinesResponse>
}