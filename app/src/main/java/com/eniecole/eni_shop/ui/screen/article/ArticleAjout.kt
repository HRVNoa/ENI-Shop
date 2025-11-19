package com.eniecole.eni_shop.ui.screen.article

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.eniecole.eni_shop.ui.common.MyTextFieldNumber
import com.eniecole.eni_shop.ui.common.MyTextFieldString
import com.eniecole.eni_shop.ui.screen.categorie.CategorieDropdownMenu

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ControllerArticleAjout(
    modifier: Modifier = Modifier) {
    ArticleAjout()
}

@Composable
fun ArticleAjout(modifier: Modifier = Modifier) {

    val context = LocalContext.current
    var titre by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var prix by remember { mutableStateOf("") }
    var selectedCategorie by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        MyTextFieldString(label = "Titre", value = titre, onChangeValue = {titre = it})
        MyTextFieldString(label = "Description", value = description, onChangeValue = {description = it})
        MyTextFieldNumber(label = "Prix", value = prix, onChangeValue = {prix = it})
        CategorieDropdownMenu(selectedCategorie = selectedCategorie, onCategorieChange = {selectedCategorie = it})
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Button(
                onClick = {
                    Toast.makeText(context, "Article enregistré", Toast.LENGTH_LONG).show()
                }
            ) {
                Text(text = "Enregister")
            }
        }
    }
}