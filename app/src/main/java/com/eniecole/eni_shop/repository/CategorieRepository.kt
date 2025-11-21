package com.eniecole.eni_shop.repository

import com.eniecole.eni_shop.dao.CategorieDao
import com.eniecole.eni_shop.bo.Categorie
import com.eniecole.eni_shop.dao.DaoType

class CategorieRepository(
    private val categorieDaoRoom: CategorieDao,
    private val categorieDaoMemory: CategorieDao
) {

    suspend fun getCategorie(id: Long, type: DaoType = DaoType.MEMORY): Categorie? {
        if (type == DaoType.MEMORY){
            return categorieDaoMemory.findById(id)
        }
        return categorieDaoRoom.findById(id)
    }

    suspend fun addCategorie(categorie: Categorie): Long {
        return categorieDaoRoom.insert(categorie)
    }

    suspend fun findAll(type: DaoType = DaoType.MEMORY): List<Categorie> {
        if (type == DaoType.MEMORY){
            return categorieDaoMemory.findAll()
        }
        return categorieDaoRoom.findAll()
    }

}