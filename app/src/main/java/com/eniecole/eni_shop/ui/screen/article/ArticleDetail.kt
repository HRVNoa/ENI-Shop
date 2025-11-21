package com.eniecole.eni_shop.ui.screen.article

import android.annotation.SuppressLint
import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.eniecole.eni_shop.bo.Article
import com.eniecole.eni_shop.ui.common.Error404
import com.eniecole.eni_shop.utils.decimal
import com.eniecole.eni_shop.utils.toFrench
import com.eniecole.eni_shop.vm.ArticleDetailViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ControllerArticleDetail(
    id: Long,
    modifier: Modifier = Modifier,
    articleDetailViewModel: ArticleDetailViewModel = viewModel(factory = ArticleDetailViewModel.Factory())
) {

    LaunchedEffect(Unit) {
        articleDetailViewModel.loadArticle(id)
    }
    val article by articleDetailViewModel.article.collectAsState()
    val isFavoris by articleDetailViewModel.isFavoris.collectAsState()
    article?.let {
        it1 -> ArticleDetail(
            article = it1,
            isFavoris = isFavoris,
            modifier = modifier,
            onCheckedChange = {
                if (isFavoris){
                    articleDetailViewModel.deleteArticle(it1)
                }else{
                    articleDetailViewModel.insertArticle()
                }
            }
        )
    } ?: Error404(modifier = modifier)
}

@Composable
fun ArticleDetail(
    article: Article,
    isFavoris : Boolean,
    modifier: Modifier = Modifier,
    onCheckedChange: () -> Unit
) {

    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
        ) {
            Text(
                text = article.name,
                fontSize = 28.sp,
                textAlign = TextAlign.Justify,
                modifier = Modifier.clickable(
                    onClick = {
                        val url = "https://google.fr/search?q=\"eni-shop\"%20+"+article.name.replace(" ", "+")
                        Intent(Intent.ACTION_VIEW, url.toUri()).also {
                            context.startActivity(it)
                        }
                    }
                )
            )
            AsyncImage(
                model = article.urlImage,
                contentDescription = article.name,
                modifier = Modifier
                    .height(250.dp)
                    .fillMaxWidth()
                    .padding(top = 16.dp, bottom = 16.dp)
            )
            Text(
                text = article.description,
                fontSize = 18.sp,
                textAlign = TextAlign.Justify
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Prix : "+article.price.decimal(2)+" €",
                fontSize = 16.sp,
                modifier = Modifier.testTag("testPrix")
            )
            Text(
                text = "Date de sortie : "+article.date.toFrench(),
                fontSize = 16.sp
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = isFavoris,
                onCheckedChange = {
                    onCheckedChange()
                }
            )
            Text(text = "Favoris")
        }
    }
}