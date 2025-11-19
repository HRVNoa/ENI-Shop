package com.eniecole.eni_shop.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.eniecole.eni_shop.bo.Article
import com.eniecole.eni_shop.bo.Categorie
import com.eniecole.eni_shop.repository.ArticleRepository
import com.eniecole.eni_shop.repository.CategorieRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ArticleListViewModel(
    private val articleRepository: ArticleRepository = ArticleRepository,
    private val categorieRepository: CategorieRepository = CategorieRepository
): ViewModel() {

    private val _articles = MutableStateFlow<List<Article>>(emptyList())
    val articles : StateFlow<List<Article>> = _articles.asStateFlow()
    private val _categories = MutableStateFlow<List<Categorie>>(emptyList())
    val categories : StateFlow<List<Categorie>> = _categories.asStateFlow()

    init {
        _articles.value = articleRepository.findAll()
        _categories.value = categorieRepository.findAll()
    }

    companion object {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                return ArticleListViewModel(
                    ArticleRepository
                ) as T
            }
        }
    }

}