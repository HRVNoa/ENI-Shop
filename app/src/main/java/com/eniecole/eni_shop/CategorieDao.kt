package com.eniecole.eni_shop

import com.eniecole.eni_shop.bo.Article
import com.eniecole.eni_shop.bo.Categorie
import com.eniecole.eni_shop.dao.memory.ArticleDaoMemoryImpl

interface CategorieDao {

    fun findById(id : Long): Categorie?
    fun findAll(): MutableList<Categorie>

    fun insert(categorie: Categorie): Long

}