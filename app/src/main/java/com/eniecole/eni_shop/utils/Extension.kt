package com.eniecole.eni_shop.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun Date.toFrench(): String {
    val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    return formatter.format(this)
}

fun Double.decimal(int: Int): String {
    return String.format(Locale.FRANCE, "%.${int}f", this)
}