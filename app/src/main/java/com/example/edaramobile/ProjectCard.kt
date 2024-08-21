package com.example.edaramobile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.edaramobile.data.ProjectEntity

@Composable
fun ProjectCard(
    state: ProjectEntity,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier, 
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        )
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // title
            Text(
                text = state.title,
                style = MaterialTheme.typography.headlineLarge
            )

            // description
            Text(
                text = state.description,
                style = MaterialTheme.typography.bodyLarge
            )


        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ProjectCardPreview() {
    val project = ProjectEntity(22, "Edara Project", "something about the first project in this preview")
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier
            .heightIn(300.dp, 500.dp)
            .fillMaxSize()) {
        ProjectCard(
            state = project
        )
    }
}