package com.sorianog.newsshortsapp.repository

import com.sorianog.newsshortsapp.data.datasource.NewsDataSource
import com.sorianog.newsshortsapp.data.entity.TopHeadlinesResponse
import com.sorianog.utilities.ResourceState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val newsDataSource: NewsDataSource
) {

    suspend fun getTopNewsHeadlines(country: String): Flow<ResourceState<TopHeadlinesResponse>> {
        return flow {
            emit(ResourceState.Loading())

            val response = newsDataSource.getTopNewsHeadlines(country)

            if (response.isSuccessful && response.body() != null) {
               emit(ResourceState.Success(response.body()!!))
            } else {
                emit(ResourceState.Error("Error fetching top news headlines"))
            }
        }.catch { e ->
            emit(ResourceState.Error(e.localizedMessage ?: "Error in flow occurred"))
        }
    }
}