package com.eniecole.eni_shop.dao.network

import com.eniecole.eni_shop.dao.ArticleDao
import com.eniecole.eni_shop.bo.Article

class ArticleDaoNetworkImpl: ArticleDao {
    override suspend fun findById(id: Long): Article {
        TODO("Not yet implemented")
    }

    override suspend fun findAll(): MutableList<Article> {
        TODO("Not yet implemented")
    }

    override suspend fun insert(article: Article): Long {
        TODO("Not yet implemented")
    }

    override suspend fun delete(articleToDelete: Article) {
        TODO("Not yet implemented")
    }
}