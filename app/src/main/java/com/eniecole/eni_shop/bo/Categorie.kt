package com.eniecole.eni_shop.bo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
class Categorie(
    private var _id: Long,
    private var _name: String,
) : Parcelable {

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

    override fun toString(): String {
        return "Categorie:\n" +
                "id=$_id,\n" +
                "name='$_name',\n"
    }


}