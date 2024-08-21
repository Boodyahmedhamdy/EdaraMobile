package com.example.edaramobile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.edaramobile.data.ProjectEntity

@Composable
fun AddProjectScreen(
    title: String,
    description: String,
    modifier: Modifier = Modifier,
    onClickCreateProject: () -> Unit = {},
    onProjectTitleChanged: (String) -> Unit = {},
    onProjectDescriptionChanged: (String) -> Unit = {}
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // title of the screen
        Text(
            text = "Create Project",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold
        )
        // title
        TextField(
            value = title, onValueChange = onProjectTitleChanged,
            label = { Text(text = "Project Title") }
        )
        // description
        TextField(
            value = description, onValueChange = onProjectDescriptionChanged,
            label = { Text(text = "Description") }
        )

        Button(onClick = onClickCreateProject) {
            Text(text = "Create Project")
        }






    }

}