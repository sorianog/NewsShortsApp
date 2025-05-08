package com.sorianog.newsshortsapp.data.api

import com.sorianog.newsshortsapp.data.entity.TopHeadlinesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    // https://newsapi.org/v2/top-headlines?country=us&apiKey=<KEY>
    @GET("v2/top-headlines")
    suspend fun getTopNewsHeadlines(
        @Query("country") country: String, // ex: "us"
        @Query("apiKey") apiKey: String = "YOUR_API_KEY"
    ) : Response<TopHeadlinesResponse>
}