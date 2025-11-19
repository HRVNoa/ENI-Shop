package com.eniecole.eni_shop.bo

import java.util.Date

class Article(
    private var _id: Long,
    private var _name: String,
    private var _description: String,
    private var _price: Double,
    private var _urlImage: String,
    private var _category: Categorie,
    private var _date: Date,
) {

    var id: Long
        get() = _id
        set(value) {
            _id = value
        }

    var name: String
        get() = _name
        set(value) {
            _name = value
        }

    var description: String
        get() = _description
        set(value) {
            _description = value
        }

    var price: Double
        get() = _price
        set(value) {
            _price = value
        }

    var urlImage: String
        get() = _urlImage
        set(value) {
            _urlImage = value
        }

    var category: Categorie
        get() = _category
        set(value) {
            _category = value
        }

    var date: Date
        get() = _date
        set(value) {
            _date = value
        }

    override fun toString(): String {
        return "Article:\n" +
                "id=$_id,\n" +
                "name='$_name',\n" +
                "description='$_description',\n" +
                "price=$_price,\n" +
                "urlImage='$_urlImage',\n" +
                "category='$_category',\n" +
                "date=$_date,\n"
    }


}