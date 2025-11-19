package com.eniecole.eni_shop.ui.screen.categorie

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CategorieDropdownMenu(
    selectedCategorie: String,
    onCategorieChange: (String) -> Unit,
    categories: List<String> = listOf("Electronics", "Jewelery", "Men's clothing", "Women's clothing"),
    modifier: Modifier = Modifier,
) {
    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .border(
                1.dp,
                color = MaterialTheme.colorScheme.secondary,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(text = "Catégorie", fontSize = 22.sp)
            Box(
            ) {
                TextField(
                    value = selectedCategorie,
                    onValueChange = {},
                    placeholder = { Text(text = "Choisir une catégorie") },
                    enabled = false,
                    readOnly = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { expanded = !expanded },
                    trailingIcon = {
                        if (expanded){
                            Icon(
                                Icons.Default.KeyboardArrowUp,
                                contentDescription = ""
                            )
                        }else{
                            Icon(
                                Icons.Default.KeyboardArrowDown,
                                contentDescription = ""
                            )
                        }
                    },
                )
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    categories.forEach { item ->
                        DropdownMenuItem(
                            text = { Text(item) },
                            onClick = {
                                expanded = false
                                onCategorieChange(item)
                            }
                        )
                    }
                }
            }
        }
    }
}