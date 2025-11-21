package com.eniecole.eni_shop.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.eniecole.eni_shop.bo.Categorie

@Dao
interface CategorieDao {

    @Query("SELECT id, name FROM Categorie WHERE id = :id")
    suspend fun findById(id : Long): Categorie?

    @Query("SELECT id, name FROM Categorie")
    suspend fun findAll(): List<Categorie>

    @Insert
    suspend fun insert(categorie: Categorie): Long

}