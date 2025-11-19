package com.eniecole.eni_shop.dao.memory

import com.eniecole.eni_shop.ArticleDao
import com.eniecole.eni_shop.bo.Article
import com.eniecole.eni_shop.repository.CategorieRepository
import java.util.Date

class ArticleDaoMemoryImpl (
    private var _articleMemory : MutableList<Article> = mutableListOf(
        Article(
            _id = 1,
            _name = "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
            _description = "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
            _price = 109.95,
            _urlImage = "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_t.png",
            _category = CategorieRepository.getCategorie(3)!!,
            _date = Date(),
        ),
        Article(
            _id = 2,
            _name = "Mens Casual Premium Slim Fit T-Shirts",
            _description = "Slim-fitting style, contrast raglan long sleeve, three-button henley placket, light weight & soft fabric for breathable and comfortable wearing. And Solid stitched shirts with round neck made for durability and a great fit for casual fashion wear and diehard baseball fans. The Henley style round neckline includes a three-button placket.",
            _price = 22.3,
            _urlImage = "https://fakestoreapi.com/img/71-3HjGNDUL._AC_SY879._SX._UX._SY._UY_t.png",
            _category = CategorieRepository.getCategorie(2)!!,
            _date = Date(),
        ),
        Article(
            _id = 3,
            _name = "Mens Cotton Jacket",
            _description = "great outerwear jackets for Spring/Autumn/Winter, suitable for many occasions, such as working, hiking, camping, mountain/rock climbing, cycling, traveling or other outdoors. Good gift choice for you or your family member. A warm hearted love to Father, husband or son in this thanksgiving or Christmas Day.",
            _price = 55.99,
            _urlImage = "https://fakestoreapi.com/img/71li-ujtlUL._AC_UX679_t.png",
            _category = CategorieRepository.getCategorie(3)!!,
            _date = Date(),
        )
    )
) : ArticleDao {

    override fun findById(id: Long): Article? {
        return this._articleMemory.find { article -> article.id == id }
    }

    override fun findAll(): MutableList<Article> {
        return this._articleMemory
    }

    override fun insert(article: Article): Long {
        article.id = (_articleMemory.size+1).toLong()
        this._articleMemory.add(article)
        return article.id
    }
}