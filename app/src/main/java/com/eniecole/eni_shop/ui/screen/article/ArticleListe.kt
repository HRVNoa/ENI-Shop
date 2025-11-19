package com.eniecole.eni_shop.ui.screen.article

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.eniecole.eni_shop.bo.Article
import com.eniecole.eni_shop.bo.Categorie
import com.eniecole.eni_shop.ui.common.CategorieFilterChip
import com.eniecole.eni_shop.ui.common.Error404
import com.eniecole.eni_shop.vm.ArticleListViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ControllerArticleListe(
    modifier: Modifier = Modifier,
    onArticleClick: (Long) -> Unit,
    articleListViewModel: ArticleListViewModel = viewModel(factory = ArticleListViewModel.Factory)
) {
    val articles by articleListViewModel.articles.collectAsState()
    val categories by articleListViewModel.categories.collectAsState()
    var selectedCategory: Categorie? by rememberSaveable() { mutableStateOf(null) }

    ArticleListe(
        categories = categories as MutableList<Categorie>,
        articles = articles as MutableList<Article>,
        selectedCategory = selectedCategory,
        modifier = modifier,
        onArticleClick = onArticleClick,
        onCategorieSelected = {
            selectedCategory = it
        }
    )
}

@Composable
fun ArticleListe(
    categories: MutableList<Categorie>,
    articles: MutableList<Article>,
    selectedCategory: Categorie?,
    onCategorieSelected: (Categorie?) -> Unit,
    onArticleClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {

    Column(modifier = modifier
        .fillMaxSize()
        .padding(16.dp)
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
        ) {
            CategorieFilterChip(
                categories = categories,
                selectedCategorie = selectedCategory,
                onCategorieChange = {
                    onCategorieSelected(it)
                }
            )
        }

        val filtredArticles = articles.filter { article -> article.category.equals(selectedCategory) }
        val articleItems = if (filtredArticles.isEmpty() && selectedCategory == null) {
            articles
        } else {
            filtredArticles
        }
        if (articleItems.isEmpty()){
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text("Pas d'articles dans cette catégorie")
            }
        }else{
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(articleItems) { article ->
                    ArticleItem(article = article, modifier = Modifier.clickable(onClick = {onArticleClick(article.id)}))
                }
            }
        }
    }
}