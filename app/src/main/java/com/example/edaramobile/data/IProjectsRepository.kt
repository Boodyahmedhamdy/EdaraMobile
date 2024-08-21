package com.example.edaramobile.data

interface IProjectsRepository {

    fun getAllProjects(): List<ProjectEntity>
    fun getProjectById(id: Int): ProjectEntity?


}