package com.eniecole.eni_shop

import com.eniecole.eni_shop.bo.Article
import com.eniecole.eni_shop.dao.memory.ArticleDaoMemoryImpl

interface ArticleDao {

    fun findById(id : Long): Article?
    fun findAll(): MutableList<Article>

    fun insert(article: Article): Long

}