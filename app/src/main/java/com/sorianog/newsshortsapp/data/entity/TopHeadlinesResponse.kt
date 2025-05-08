package com.sorianog.newsshortsapp.data.entity

// https://newsapi.org/docs/endpoints/top-headlines
data class TopHeadlinesResponse(
    var status: String,
    var totalResults: Int,
    var articles: List<Article>
)

data class NewsSource(
    var id: String? = null,
    var name: String? = null
)

data class Article(
    var source: NewsSource? = NewsSource("", ""),
    var author: String? = null,
    var title: String? = null,
    var description: String? = null,
    var url: String? = null,
    var urlToImage: String? = null,
    var publishedAt: String? = null,
    var content: String? = null
)
