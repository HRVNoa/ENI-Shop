package com.eniecole.eni_shop.bo

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable


@Parcelize
@Entity
@Serializable
class Categorie(
    @PrimaryKey
    var id: Long,
    var name: String,
) : Parcelable {
    override fun toString(): String {
        return "Categorie:\n" +
                "id=$id,\n" +
                "name='$name',\n"
    }
}