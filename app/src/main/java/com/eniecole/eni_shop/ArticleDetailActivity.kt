package com.eniecole.eni_shop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.eniecole.eni_shop.ui.screen.article.ControllerArticleDetail
import com.eniecole.eni_shop.ui.theme.Eni_shopTheme

class ArticleDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Eni_shopTheme {
                val articleId = intent.getLongExtra("articleId", 0)
                ControllerArticleDetail(articleId)
            }
        }
    }
}