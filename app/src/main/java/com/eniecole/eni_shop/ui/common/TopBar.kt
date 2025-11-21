package com.eniecole.eni_shop.ui.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.eniecole.eni_shop.DataStoreManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(modifier: Modifier = Modifier, canBack: Boolean = false, onBackClic: () -> Unit, onRefreshClic: () -> Unit) {

    var expanded by remember { mutableStateOf(false) }
    val coroutine = rememberCoroutineScope()
    val context = LocalContext.current
    var isDarkTheme by remember() { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        DataStoreManager.isDarkTheme(context = context).collect { value ->
            isDarkTheme = value
        }
    }

    TopAppBar(
        title = {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = "",
                    modifier = Modifier.size(34.dp)
                )
                Text(
                    text = "ENI-SHOP",
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 34.sp
                )
            }
        },
        navigationIcon = {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxHeight()
            ){
                if (canBack) {
                    IconButton(
                        onClick = {
                            onBackClic()
                        },

                    ) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back")
                    }
                } else {
                    IconButton(onClick = {}, enabled = false) {}
                }
            }
        },
        actions = {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxHeight()
            ) {
                IconButton(
                    onClick = {
                        expanded = true
                    },
                ) {
                    Icon(imageVector = Icons.Default.MoreVert,
                        contentDescription = "Plus d'action",
                    )
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        DropdownMenuItem(
                            text = {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    modifier = Modifier.width(180.dp).clickable(onClick = {
                                        onRefreshClic()
                                    })
                                ) {
                                    Text("Refresh")
                                    Icon(
                                        Icons.Default.Refresh,
                                        "Refresh"
                                    )
                                }
                            },
                            onClick = {
                                expanded = false
                            }
                        )
                        DropdownMenuItem(
                            text = {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    modifier = Modifier.width(180.dp)
                                ) {
                                    Text("Dark Mode")
                                    Switch(
                                        checked = isDarkTheme,
                                        onCheckedChange = {
                                            coroutine.launch( Dispatchers.IO){
                                                DataStoreManager.setDarkTheme(context = context, value = !isDarkTheme)
                                            }
                                        }
                                    )
                                }
                            },
                            onClick = {
                                expanded = false
                            }
                        )

                    }
                }
            }
        },
        modifier = Modifier
            .shadow(5.dp)
            .height(120.dp)
    )
}