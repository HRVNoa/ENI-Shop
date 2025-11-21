package com.eniecole.eni_shop.ui.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.eniecole.eni_shop.ArticleAjouterRoute
import com.eniecole.eni_shop.ArticleFavorisRoute
import com.eniecole.eni_shop.ArticleListeRoute

@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    BottomAppBar(
        content = {
            Row(
                modifier = Modifier.fillMaxWidth().height(75.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                IconButton(onClick = {
                    navController.navigate(ArticleListeRoute.route)
                }) {
                    Icon(
                        imageVector = Icons.Default.ShoppingCart,
                        contentDescription = "Shop",
                        modifier = Modifier.fillMaxHeight().size(34.dp)
                    )
                }
                IconButton(onClick = {
                    navController.navigate(ArticleFavorisRoute.route)
                }) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Favoris",
                        modifier = Modifier.fillMaxHeight().size(34.dp)
                    )
                }
            }
        },
        modifier = Modifier
            .shadow(5.dp)
            .height(75.dp)
    )
}