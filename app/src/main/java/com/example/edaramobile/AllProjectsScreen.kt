package com.example.edaramobile

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.edaramobile.data.ProjectEntity

@Composable
fun AllProjectsScreen(
    projects: List<ProjectEntity>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(projects) {
            ProjectCard(
                state = it,
                modifier = Modifier.padding(8.dp)
            )
        }
    }

}