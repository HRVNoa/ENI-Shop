package com.eniecole.eni_shop.repository

import com.eniecole.eni_shop.CategorieDao
import com.eniecole.eni_shop.DaoFactory
import com.eniecole.eni_shop.DaoType
import com.eniecole.eni_shop.bo.Categorie

object CategorieRepository {

    private val categorieDao: CategorieDao = DaoFactory.createCategorieDao(DaoType.MEMORY)

    fun getCategorie(id: Long): Categorie? {
        return categorieDao.findById(id)
    }

    fun addCategorie(categorie: Categorie): Long {
        return categorieDao.insert(categorie)
    }

    fun findAll(): MutableList<Categorie> {
        return categorieDao.findAll()
    }

}