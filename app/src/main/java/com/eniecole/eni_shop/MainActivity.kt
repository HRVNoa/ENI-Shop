package com.eniecole.eni_shop

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.eniecole.eni_shop.ui.common.BottomBar
import com.eniecole.eni_shop.ui.common.TopBar
import com.eniecole.eni_shop.ui.screen.article.ArticleAjouterFAB
import com.eniecole.eni_shop.ui.screen.article.ControllerArticleAjout
import com.eniecole.eni_shop.ui.screen.article.ControllerArticleListe
import com.eniecole.eni_shop.ui.screen.article.ControllerArticleDetail
import com.eniecole.eni_shop.ui.screen.article.ControllerArticleFavoris
import com.eniecole.eni_shop.ui.theme.Eni_shopTheme

private const val TAG = "MainActivity"
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val context = LocalContext.current
            var isDarkTheme by remember() { mutableStateOf(false) }

            LaunchedEffect(Unit) {
                DataStoreManager.isDarkTheme(context = context).collect { value ->
                    isDarkTheme = value
                }
            }

            Eni_shopTheme(
                darkTheme = isDarkTheme
            ) {
                EniShopApp()
            }
        }
    }
}

@Composable
fun EniShopApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        topBar = {
            TopBar(
                onBackClic = { navController.popBackStack() },
                onRefreshClic = { navController.navigate(currentRoute ?: "") },
                canBack = currentRoute != ArticleListeRoute.route)
        },
        floatingActionButton = {
            if (currentRoute.toString().contains(ArticleListeRoute.route)) {
                ArticleAjouterFAB(
                    onArticleAjouterClick = {
                        navController.navigate(ArticleAjouterRoute.route)
                    }
                )
            }
        },
        bottomBar = { BottomBar(navController = navController) }
    ){ padding ->
        Column(
            Modifier.padding(padding
        )
        ) {
            EniShopNavHost(
                navController = navController
            )
        }
    }
}

@Composable
fun EniShopNavHost(
    modifier: Modifier = Modifier,
    navController : NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = ArticleListeRoute.route
    ) {

        composable(
            route = ArticleListeRoute.route
        ) {
            ControllerArticleListe(
                modifier = modifier,
                onArticleClick = { id ->
                    navController.navigate("${ArticleDetailRoute.route}/$id")
                }
            )
        }

        composable(
            route = ArticleFavorisRoute.route
        ) {
            ControllerArticleFavoris(
                modifier = modifier,
                onArticleClick = { id ->
                    navController.navigate("${ArticleDetailRoute.route}/$id")
                }
            )
        }

        composable(
            route = ArticleDetailRoute.routeWithArgs,
            arguments = ArticleDetailRoute.args
        ) { backStackEntry ->
            val articleId = backStackEntry.arguments?.getLong(ArticleDetailRoute.argId) ?: 0
            ControllerArticleDetail(id = articleId)
        }

        composable(
            route = ArticleAjouterRoute.route,
        ) { backStackEntry ->
            ControllerArticleAjout()
        }
    }
}
