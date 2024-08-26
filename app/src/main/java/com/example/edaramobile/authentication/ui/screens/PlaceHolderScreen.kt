package com.example.edaramobile.authentication.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PlaceHolderScreen(
    title: String,
    modifier: Modifier = Modifier,
    message: String = "Not Implemented Yet, this is just a Placeholder",
) {
    Box(
        modifier = modifier.background(
            Brush.linearGradient(listOf(
                Color.Gray, Color.White, Color.Gray
            ))
        ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ){
            // title
            Text(
                text = title,
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            // message
            Text(
                message,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun PlaceHolderScreenPreview() {
    PlaceHolderScreen(title = "PlaceHolder Screen", modifier = Modifier.fillMaxSize())
}

