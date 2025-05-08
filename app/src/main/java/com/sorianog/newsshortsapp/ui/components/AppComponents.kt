package com.sorianog.newsshortsapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.sorianog.newsshortsapp.R
import com.sorianog.newsshortsapp.data.entity.Article
import com.sorianog.newsshortsapp.data.entity.TopHeadlinesResponse

@Composable
fun LoadingIndicator() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(100.dp)
                .padding(10.dp),
            color = colorResource(R.color.app_green)
        )
    }
}

@Composable
fun NewsRowComponent(
    article: Article
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp),
            model = ImageRequest.Builder(context = LocalContext.current)
                .data(article.urlToImage)
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.ic_loading_image),
            error = painterResource(R.drawable.ic_no_image),
            contentScale = ContentScale.Crop,
            contentDescription = "Image for news article"
        )

        Spacer(modifier = Modifier.size(24.dp))

        NewsTitleComponent(article.title ?: stringResource(R.string.no_title))
        TextComponent("${article.description}")
        Spacer(modifier = Modifier.weight(1f))
        AuthorDetailsComponent(article.author, article.source?.name)
    }
}

@Preview
@Composable
fun NewsRowComponentPreview() {
    val fakeArticle = Article(
        author = "Ash Ketchum",
        title = "Breaking News",
        description = "This is the article's description text"
    )
    NewsRowComponent(fakeArticle)
}

@Composable
fun NewsList(
    news: TopHeadlinesResponse
) {
    LazyColumn() {
        items(news.articles) { article ->
            TextComponent(textVal = article.title ?: stringResource(R.string.no_title))
        }
    }
}

@Composable
fun NewsTitleComponent(titleText: String) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(8.dp),
        text = titleText,
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    )
}

@Composable
fun AuthorDetailsComponent(
    authorName: String?,
    sourceName: String?
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp, bottom = 30.dp)
    ) {
        authorName?.let {
            Text(text = authorName, fontStyle = FontStyle.Italic)
        }

        sourceName?.let {
            Text(text = sourceName, fontStyle = FontStyle.Italic)
        }
    }
}

@Composable
fun TextComponent(
    textVal: String,
    isCentered: Boolean = false
) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(8.dp),
        text = textVal,
        style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
        ),
        textAlign = if (isCentered) TextAlign.Center else TextAlign.Start
    )
}

@Composable
fun EmptyStateComponent(
    image: Painter,
    message: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = image,
            contentDescription = null
        )
        TextComponent(message, isCentered = true)
    }
}