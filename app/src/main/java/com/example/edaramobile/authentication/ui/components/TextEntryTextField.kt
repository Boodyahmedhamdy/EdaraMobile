package com.example.edaramobile.authentication.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun TextEntryTextField(
    modifier: Modifier = Modifier,
    labelString: String = "",
    value: String = "",
    onValueChanged: (String) -> Unit = {},
    leadingIcon: @Composable (() -> Unit)? = null,
    singleLine: Boolean = true,
    suffixText: String = "",
    hintText: String = ""
) {
    Column(
        modifier = modifier
    ) {
        Text(
            labelString,
            color = MaterialTheme.colorScheme.primary,
            fontSize = 24.sp,
            textAlign = TextAlign.Start,
            modifier = Modifier.fillMaxWidth()
        )
        Text(text = hintText, modifier = Modifier.alpha(0.7f))

        OutlinedTextField(
            value = value,
            onValueChange = { onValueChanged(it) },
            leadingIcon = leadingIcon,
            label = { Text(labelString) },
            singleLine = singleLine,
            suffix = { Text(suffixText) },
            modifier = Modifier.fillMaxWidth()
        )

    }

}