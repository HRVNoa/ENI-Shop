package com.eniecole.eni_shop.bo

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.util.Date



@Entity
class Article(
    @PrimaryKey
    var id: Long = 0,
    var name: String,
    var description: String,
    var price: Double,
    var urlImage: String,
    var category: Categorie,
    var date: Date,
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