package com.example.edaramobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.edaramobile.data.ProjectEntity
import com.example.edaramobile.data.ProjectRepository
import com.example.edaramobile.ui.theme.EdaraMobileTheme
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val bottomSheetState = rememberModalBottomSheetState()
            val scope = rememberCoroutineScope()
            var showBottomSheet by remember {
                mutableStateOf(false)
            }
            EdaraMobileTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    floatingActionButton = {
                        FloatingActionButton(onClick = {
                            showBottomSheet = true
                        }) {
                            Icon(
                                imageVector = Icons.Outlined.Add,
                                contentDescription = "add new Project"
                            )
                        }
                    },
                    topBar = {
                        CenterAlignedTopAppBar(title = { Text(text = "All Projects") })
                    }
                ) { innerPadding ->
                    val projectsRepo = ProjectRepository()
                    val projectsState: State<List<ProjectEntity>> = flowOf(projectsRepo.projects).collectAsState(
                        initial = emptyList()
                    )

                    if(showBottomSheet) {
                        ModalBottomSheet(
                            onDismissRequest = { showBottomSheet = false },
                            sheetState = bottomSheetState
                        ) {
                            val project by remember {
                                mutableStateOf(ProjectEntity())
                            }
                            var title by remember {
                                mutableStateOf("")
                            }
                            var description by remember {
                                mutableStateOf("")
                            }
                            AddProjectScreen(
                                title = title,
                                description = description,
                                onProjectTitleChanged = {
                                    title = it
                                },
                                onProjectDescriptionChanged = {
                                    description = it
                                },
                                modifier = Modifier
                                    .padding(16.dp)
                                    .fillMaxSize(),

                                onClickCreateProject = {
                                    projectsRepo.projects.add(
                                        ProjectEntity(title = title, description = description)
                                    )
                                    // hide bottom sheet
                                    scope.launch { bottomSheetState.hide() }.invokeOnCompletion {
                                        if (!bottomSheetState.isVisible) {
                                            showBottomSheet = false
                                        }
                                    }
                                },
                            )
                        }
                    } else {
                        AllProjectsScreen(
                            projects = projectsState.value,
                            modifier = Modifier.padding(innerPadding)
                        )
                    }

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EdaraMobileTheme {
        Greeting("Android")
    }
}

/*
* add dependencies [navigation, viewmodel]
* create navHost
* create navController
* create addProject Screen
*
*
*
* */





















