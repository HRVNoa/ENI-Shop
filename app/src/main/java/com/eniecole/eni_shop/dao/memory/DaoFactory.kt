package com.eniecole.eni_shop.dao.memory

import com.eniecole.eni_shop.dao.ArticleDao
import com.eniecole.eni_shop.dao.CategorieDao
import com.eniecole.eni_shop.dao.DaoType
import com.eniecole.eni_shop.dao.network.ArticleDaoNetworkImpl
import com.eniecole.eni_shop.dao.network.CategorieDaoNetworkImpl

abstract class DaoFactory {

    companion object{
        fun createArticleDao(type: DaoType): ArticleDao {
            if (type == DaoType.MEMORY){
                return ArticleDaoMemoryImpl()
            }
            return ArticleDaoNetworkImpl()
        }
        fun createCategorieDao(type: DaoType): CategorieDao {
            if (type == DaoType.MEMORY){
                return CategorieDaoMemoryImpl()
            }
            return CategorieDaoNetworkImpl()
        }
    }

}