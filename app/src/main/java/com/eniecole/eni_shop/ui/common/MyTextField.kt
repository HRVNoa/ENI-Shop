package com.eniecole.eni_shop.ui.common

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MyTextFieldString(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    onChangeValue : (String) -> Unit,
) {
    Column(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.secondary,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(8.dp)
    ) {
        Text(text = label, fontSize = 22.sp)
        TextField(
            value = value,
            onValueChange = {
                onChangeValue(it)
            },
            modifier = Modifier.fillMaxWidth(),
        )
    }
}

@Composable
fun MyTextFieldNumber(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    onChangeValue : (String) -> Unit,
) {
    Column(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.secondary,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(8.dp)
    ) {
        Text(text = label, fontSize = 22.sp)
        TextField(
            value = value,
            onValueChange = {
                onChangeValue(it)
            },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        )
    }
}