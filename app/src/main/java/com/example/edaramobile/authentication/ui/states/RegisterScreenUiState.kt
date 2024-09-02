package com.example.edaramobile.authentication.ui.states

data class RegisterScreenUiState(
    val username: String = "",
    val usernameErrorMessage: String = "",
    val firstName: String = "",
    val firstNameErrorMessage: String = "",
    val lastName: String = "",
    val lastNameErrorMessage: String = "",
    val password: String = "",
    val passwordErrorMessage: String = "",
    val confirmedPassword: String = "",
    val confirmedPasswordErrorMessage: String = "",
    val generalErrorMessage: String = "",
    val registerButtonEnabled: Boolean = true
)
