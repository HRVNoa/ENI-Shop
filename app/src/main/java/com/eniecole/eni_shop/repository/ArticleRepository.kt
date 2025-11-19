package com.eniecole.eni_shop.repository

import com.eniecole.eni_shop.ArticleDao
import com.eniecole.eni_shop.DaoFactory
import com.eniecole.eni_shop.DaoType
import com.eniecole.eni_shop.bo.Article

object ArticleRepository {

    private val articleDao: ArticleDao = DaoFactory.createArticleDao(DaoType.MEMORY)

    fun getArticle(id: Long): Article? {
        return articleDao.findById(id)
    }

    fun addArticle(article: Article): Long {
        return articleDao.insert(article)
    }

    fun findAll(): MutableList<Article> {
        return articleDao.findAll()
    }

}