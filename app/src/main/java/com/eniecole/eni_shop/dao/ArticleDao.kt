package com.eniecole.eni_shop.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.eniecole.eni_shop.bo.Article

@Dao
interface ArticleDao {

    @Query("SELECT id, name, category, description, date, price, urlImage FROM Article WHERE id = :id")
    suspend fun findById(id : Long): Article?

    @Query("SELECT id, name, category, description, date, price, urlImage FROM Article")
    suspend fun findAll(): List<Article>

    @Insert
    suspend fun insert(article: Article): Long

    @Delete
    suspend fun delete(articleToDelete: Article)

}