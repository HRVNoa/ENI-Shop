package com.eniecole.eni_shop

import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.eniecole.eni_shop.bo.Article
import com.eniecole.eni_shop.repository.ArticleRepository
import com.eniecole.eni_shop.ui.screen.article.ControllerArticleDetail
import com.eniecole.eni_shop.ui.screen.article.ControllerArticleListe
import com.eniecole.eni_shop.utils.decimal
import org.junit.Rule
import org.junit.Test

class ArticleTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testArticleDetailIsWorking(){

        val article: Article = ArticleRepository.getArticle(2)!!

        composeTestRule.setContent {
            ControllerArticleDetail(2)
        }

        composeTestRule
            .onNodeWithContentDescription(article.name)
            .assertExists()

        composeTestRule
            .onNodeWithTag("testPrix")
            .assertTextContains(article.price.decimal(2), true)

        composeTestRule
            .onNodeWithText(article.name)
            .assertHasClickAction()
            .performClick()
    }

    @Test
    fun testArticleListIsWorking(){

        val article: Article = ArticleRepository.getArticle(2)!!

        composeTestRule.setContent {
            ControllerArticleListe()
        }

        composeTestRule
            .onNodeWithContentDescription(article.name)
            .assertExists()
            .assertHasClickAction()
            .performClick()
    }
}