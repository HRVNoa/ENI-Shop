package com.eniecole.eni_shop.ui.screen.article

import android.content.Intent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.eniecole.eni_shop.ArticleDetailActivity
import com.eniecole.eni_shop.bo.Article
import com.eniecole.eni_shop.utils.decimal

@Composable
fun ArticleItem(article: Article, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Card(
        border = BorderStroke(1.dp, color = MaterialTheme.colorScheme.primary),
        shape = RoundedCornerShape(8.dp),
        modifier = modifier
    ) {
        Column(Modifier
            .fillMaxWidth()
            .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = article.urlImage,
                contentDescription = article.name,
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
                    .border(2.dp, MaterialTheme.colorScheme.tertiary, CircleShape)
                    .padding(8.dp),
            )
            Text(
                text = article.name,
                minLines = 2,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Justify
            )
            Text(article.price.decimal(2)+"€")
        }
    }

}