package com.eniecole.eni_shop.dao.memory

import com.eniecole.eni_shop.ArticleDao
import com.eniecole.eni_shop.CategorieDao
import com.eniecole.eni_shop.bo.Categorie

class CategorieDaoMemoryImpl (
    private var _categorieMemory : MutableList<Categorie> = mutableListOf(
        Categorie(
            _id = 1,
            _name = "Electronics",
        ),
        Categorie(
            _id = 2,
            _name = "Jewelery",
        ),
        Categorie(
            _id = 3,
            _name = "Men's clothing",
        ),
        Categorie(
            _id = 4,
            _name = "Women",
        ),
        Categorie(
            _id = 5,
            _name = "Music",
        ),
    )
) : CategorieDao {

    override fun findById(id: Long): Categorie? {
        return this._categorieMemory.find { categorie -> categorie.id == id }
    }

    override fun findAll(): MutableList<Categorie> {
        return this._categorieMemory
    }

    override fun insert(categorie: Categorie): Long {
        categorie.id = (_categorieMemory.size+1).toLong()
        this._categorieMemory.add(categorie)
        return categorie.id
    }
}