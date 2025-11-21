package com.eniecole.eni_shop.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.compose.viewModel
import com.eniecole.eni_shop.AppDatabase
import com.eniecole.eni_shop.bo.Article
import com.eniecole.eni_shop.dao.DaoType
import com.eniecole.eni_shop.dao.memory.DaoFactory
import com.eniecole.eni_shop.repository.ArticleRepository
import com.eniecole.eni_shop.services.ArticleService
import com.eniecole.eni_shop.services.CallArticleApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ArticleDetailViewModel(
    private val articleRepository: ArticleRepository,
    private val articleService: ArticleService
) : ViewModel() {

    private val _article = MutableStateFlow<Article?>(null)
    val article: StateFlow<Article?> = _article.asStateFlow()

    private val _isFavoris = MutableStateFlow(false)
    val isFavoris = _isFavoris.asStateFlow()



    fun loadArticle(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            _article.value = articleService.getById(id.toString())
            val articleFav = articleRepository.getArticle(id, DaoType.ROOM)
            if(articleFav != null){
                _isFavoris.value = true
            }
        }
    }

    fun insertArticle(){
        viewModelScope.launch(Dispatchers.IO) {
            _article.value?.let {
                articleRepository.addArticle(article = it, type = DaoType.ROOM)
                _isFavoris.value = true
            }
        }
    }

    fun deleteArticle(){
        viewModelScope.launch {
            _article.value?.let {
                articleRepository.delete(article = it, DaoType.ROOM)
                _isFavoris.value = false
            }
        }
    }

    companion object {
        fun Factory(): ViewModelProvider.Factory =
            object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(
                    modelClass: Class<T>,
                    extras: CreationExtras
                ): T {
                    val application = checkNotNull(extras[APPLICATION_KEY])
                    return ArticleDetailViewModel(
                        articleRepository = ArticleRepository(
                            AppDatabase.getInstance(application.applicationContext).getArticleDao(),
                            DaoFactory.createArticleDao(DaoType.MEMORY)
                        ),
                        CallArticleApi.retrofitService
                    ) as T
                }
            }
    }
}