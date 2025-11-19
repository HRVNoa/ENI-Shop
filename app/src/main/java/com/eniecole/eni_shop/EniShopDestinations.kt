package com.eniecole.eni_shop

import androidx.navigation.NavType
import androidx.navigation.navArgument

object ArticleListeRoute {
    val route: String = "article/lister"
}

object ArticleAjouterRoute {
    val route: String = "article/ajouter"
}

object ArticleDetailRoute {
    val route: String = "article/detail"

    val argId = "id"

    val args = listOf(
        navArgument(argId){
            type = NavType.LongType
        }
    )

    val routeWithArgs = "$route/{$argId}"

}
