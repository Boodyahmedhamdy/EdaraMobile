package com.example.edaramobile.authentication.ui.states

data class LoginScreenUiState(
    val username: String = "",
    val password: String = "",
    val usernameErrorMessage: String = "",
    val passwordErrorMessage: String = "",
    val isKeepLoggedIn: Boolean = false,
)
