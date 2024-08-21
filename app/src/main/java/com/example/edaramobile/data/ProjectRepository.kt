package com.example.edaramobile.data

import kotlinx.coroutines.flow.flowOf

class ProjectRepository: IProjectsRepository {
    val projects = mutableListOf(
        ProjectEntity(1, "First Project", "first project description"),
        ProjectEntity(2, "First Project", "first project description"),
        ProjectEntity(3, "First Project", "first project description"),
        ProjectEntity(4, "First Project", "first project description"),
        ProjectEntity(5, "First Project", "first project description"),
    )

    override fun getAllProjects(): List<ProjectEntity> {
        return projects
    }

    override fun getProjectById(id: Int): ProjectEntity? {
        return projects.find { it.id == id }
    }
}