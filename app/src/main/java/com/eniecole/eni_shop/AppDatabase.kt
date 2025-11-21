package com.eniecole.eni_shop

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.eniecole.eni_shop.bo.Article
import com.eniecole.eni_shop.bo.Categorie
import com.eniecole.eni_shop.dao.ArticleDao
import com.eniecole.eni_shop.dao.CategorieDao
import com.eniecole.eni_shop.utils.Converters
import kotlin.jvm.java

@Database(
    entities = [
        Article::class,
        Categorie::class
    ],
    version = 1
)
@TypeConverters(value = [
    Converters::class
])
abstract class AppDatabase: RoomDatabase() {
    abstract fun getArticleDao(): ArticleDao
    abstract fun getCategorieDao(): CategorieDao

    companion object {
        private var INSTANCE: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase {
            var instance = INSTANCE
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "eni_shop.db"
                ).build()
                INSTANCE = instance
            }
            return instance
        }
    }
}