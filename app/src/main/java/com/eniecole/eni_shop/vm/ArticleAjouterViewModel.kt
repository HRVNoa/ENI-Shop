package com.eniecole.eni_shop.vm

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
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
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ArticleAjouterViewModel(
    private val articleRepository: ArticleRepository,
) : ViewModel() {

    private val _article = MutableStateFlow<Article?>(null)
    val article: StateFlow<Article?> = _article.asStateFlow()


    companion object {
        var Factory: ViewModelProvider.Factory =
            object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(
                    modelClass: Class<T>,
                    extras: CreationExtras
                ): T {
                    val application = checkNotNull(extras[APPLICATION_KEY])
                    return ArticleAjouterViewModel(
                        articleRepository = ArticleRepository(
                            AppDatabase.getInstance(application.applicationContext).getArticleDao(),
                            DaoFactory.createArticleDao(DaoType.MEMORY)
                        ),
                    ) as T
                }
            }
    }
}