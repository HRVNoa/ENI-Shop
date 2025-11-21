package com.eniecole.eni_shop.repository

import com.eniecole.eni_shop.dao.ArticleDao
import com.eniecole.eni_shop.bo.Article
import com.eniecole.eni_shop.dao.DaoType

class ArticleRepository(
    private val articleDaoRoom: ArticleDao,
    private val articleDaoMemory: ArticleDao
) {

    suspend fun getArticle(id: Long, type: DaoType = DaoType.MEMORY): Article? {
        if (type == DaoType.MEMORY){
            return articleDaoMemory.findById(id)
        }
        return articleDaoRoom.findById(id)
    }

    suspend fun addArticle(article: Article, type: DaoType = DaoType.MEMORY): Long {
        if (type == DaoType.MEMORY){
            return articleDaoMemory.insert(article)
        }
        return articleDaoRoom.insert(article)
    }

    suspend fun findAll(type: DaoType = DaoType.MEMORY): List<Article> {
        if (type == DaoType.MEMORY){
            return articleDaoMemory.findAll()
        }
        return articleDaoRoom.findAll()
    }

    suspend fun delete(article: Article, type: DaoType = DaoType.MEMORY) {
        if (type == DaoType.MEMORY){
            articleDaoMemory.delete(article)
        }else{
            articleDaoRoom.delete(article)
        }
    }
}