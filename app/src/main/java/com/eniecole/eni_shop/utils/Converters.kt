package com.eniecole.eni_shop.utils

import androidx.room.TypeConverter
import com.eniecole.eni_shop.bo.Categorie
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.util.Date

class Converters {
    private val json = Json { encodeDefaults = true }

    @TypeConverter
    fun fromCategorie(categorie: Categorie): String = json.encodeToString(categorie)

    @TypeConverter
    fun toCategorie(value: String): Categorie = json.decodeFromString(value)

    @TypeConverter
    fun fromDate(date: Date): Long = date.time

    @TypeConverter
    fun toDate(timestamp: Long): Date = Date(timestamp)
}