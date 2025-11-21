package com.eniecole.eni_shop.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.eniecole.eni_shop.AppDatabase
import com.eniecole.eni_shop.bo.Article
import com.eniecole.eni_shop.bo.Categorie
import com.eniecole.eni_shop.dao.DaoType
import com.eniecole.eni_shop.dao.memory.DaoFactory
import com.eniecole.eni_shop.repository.ArticleRepository
import com.eniecole.eni_shop.repository.CategorieRepository
import com.eniecole.eni_shop.services.ArticleService
import com.eniecole.eni_shop.services.CallArticleApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ArticleListViewModel(
    private val articleRepository: ArticleRepository,
    private val categorieRepository: CategorieRepository,
    private val articleService: ArticleService
): ViewModel() {

    private val _articles = MutableStateFlow<List<Article>>(emptyList())
    val articles : StateFlow<List<Article>> = _articles.asStateFlow()
    private val _categories = MutableStateFlow<List<Categorie>>(emptyList())
    val categories : StateFlow<List<Categorie>> = _categories.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _articles.value = articleService.getAll()
            _categories.value = categorieRepository.findAll()
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                val application = checkNotNull(extras[APPLICATION_KEY])
                return ArticleListViewModel(
                    ArticleRepository(
                        AppDatabase.getInstance(application.applicationContext).getArticleDao(),
                        DaoFactory.createArticleDao(DaoType.MEMORY)
                    ),
                    CategorieRepository(
                        AppDatabase.getInstance(application.applicationContext).getCategorieDao(),
                        DaoFactory.createCategorieDao(DaoType.MEMORY),
                    ),
                    CallArticleApi.retrofitService
                ) as T
            }
        }
    }

}