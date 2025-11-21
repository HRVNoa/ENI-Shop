package com.eniecole.eni_shop.dao.memory

import com.eniecole.eni_shop.dao.CategorieDao
import com.eniecole.eni_shop.bo.Categorie

class CategorieDaoMemoryImpl (
    private var _categorieMemory : MutableList<Categorie> = mutableListOf(
        Categorie(
            id = 1,
            name = "Electronics",
        ),
        Categorie(
            id = 2,
            name = "Jewelery",
        ),
        Categorie(
            id = 3,
            name = "Men's clothing",
        ),
        Categorie(
            id = 4,
            name = "Women",
        ),
        Categorie(
            id = 5,
            name = "Music",
        ),
    )
) : CategorieDao {

    override suspend fun findById(id: Long): Categorie? {
        return this._categorieMemory.find { categorie -> categorie.id == id }
    }

    override suspend fun findAll(): MutableList<Categorie> {
        return this._categorieMemory
    }

    override suspend fun insert(categorie: Categorie): Long {
        categorie.id = (_categorieMemory.size+1).toLong()
        this._categorieMemory.add(categorie)
        return categorie.id
    }
}