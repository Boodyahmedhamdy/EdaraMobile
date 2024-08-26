package com.example.edaramobile.authentication.ui.states

data class RegisterScreenUiState(
    val username: String = "",
    val firstName: String = "",
    val lastName: String = "",
    val password: String = "",
    val confirmedPassword: String = ""
)
