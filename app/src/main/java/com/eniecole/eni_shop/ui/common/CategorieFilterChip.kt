package com.eniecole.eni_shop.ui.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.eniecole.eni_shop.bo.Categorie

@Composable
fun CategorieFilterChip(
    modifier: Modifier = Modifier,
    categories: List<Categorie>,
    selectedCategorie: Categorie?,
    onCategorieChange: (Categorie?) -> Unit
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(categories) { category ->
            FilterChip(
                selected = selectedCategorie == category,
                onClick = {
                    if (selectedCategorie == category){
                        onCategorieChange(null)
                    }else{
                        onCategorieChange(category)
                    }
                },
                label = {
                    Text(category.name.replaceFirstChar { c ->
                        c.uppercase()
                    })
                },
                leadingIcon =  {
                    if (selectedCategorie == category){
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = "Check"
                        )
                    }
                }
            )
        }

    }

}