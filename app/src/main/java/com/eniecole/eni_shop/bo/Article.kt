package com.eniecole.eni_shop.bo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import java.util.Date



@Entity
class Article(
    @PrimaryKey
    var id: Long = 0,

    @Json(name = "title")
    var name: String,

    var description: String,

    var price: Double,

    @Json(name = "image")
    var urlImage: String,

    @Json(ignore = true)
    var category: Categorie = Categorie(0,"null"),

    @Json(ignore = true)
    var date: Date = Date(),
) {
    override fun toString(): String {
        return "Article:\n" +
                "id=$id,\n" +
                "name='$name',\n" +
                "description='$description',\n" +
                "price=$price,\n" +
                "urlImage='$urlImage',\n" +
                "category='$category',\n" +
                "date=$date,\n"
    }
}
