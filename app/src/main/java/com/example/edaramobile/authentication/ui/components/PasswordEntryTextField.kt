package com.example.edaramobile.authentication.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.RemoveRedEye
import androidx.compose.material.icons.outlined.Shower
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun PasswordEntryTextField(
    modifier: Modifier = Modifier,
    labelText: String = "",
    value: String = "",
    onValueChanged: (String) -> Unit = {},
) {

    var showPasswordState by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = modifier
    ) {
        Text(
            labelText,
            color = MaterialTheme.colorScheme.primary,
            fontSize = 24.sp,
            textAlign = TextAlign.Start,
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = value,
            onValueChange = { onValueChanged(it) },
            leadingIcon = { Icon(Icons.Outlined.Lock, contentDescription = "password icon") },
            label = { Text(labelText) },
            singleLine = true,
            trailingIcon = {
                if(showPasswordState) {
                    Icon(
                        Icons.Outlined.Shower,
                        contentDescription = "show password",
                        modifier = Modifier.clickable { showPasswordState = !showPasswordState }
                    )
                } else {
                    Icon(
                        Icons.Outlined.RemoveRedEye,
                        contentDescription = "show password",
                        modifier = Modifier.clickable { showPasswordState = !showPasswordState }
                    )
                }
            },
            visualTransformation = if(showPasswordState) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
            modifier = Modifier.fillMaxWidth()
        )
    }

}