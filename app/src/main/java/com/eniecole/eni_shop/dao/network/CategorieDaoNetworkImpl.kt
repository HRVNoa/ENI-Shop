package com.eniecole.eni_shop.dao.network

import com.eniecole.eni_shop.dao.CategorieDao
import com.eniecole.eni_shop.bo.Categorie

class CategorieDaoNetworkImpl: CategorieDao {
    override suspend fun findById(id: Long): Categorie {
        TODO("Not yet implemented")
    }

    override suspend fun findAll(): MutableList<Categorie> {
        TODO("Not yet implemented")
    }

    override suspend fun insert(categorie: Categorie): Long {
        TODO("Not yet implemented")
    }
}