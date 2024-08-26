package com.example.edaramobile.authentication.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.edaramobile.authentication.ui.states.LoginScreenUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AuthenticationViewModel: ViewModel() {


    // -------------- Login Screen START --------------------
    private val _loginScreenState: MutableStateFlow<LoginScreenUiState> = MutableStateFlow(LoginScreenUiState())
    val loginScreenState = _loginScreenState.asStateFlow()


    fun setUsernameInLoginScreen(username: String) {
        _loginScreenState.update { it.copy(username = username) }
    }
    fun setPasswordInLoginScreen(password: String) {
        _loginScreenState.update { it.copy(password = password) }
    }
    fun setIsKeepLoggedInInLoginScreen(isKeepLoggedIn: Boolean) {
        _loginScreenState.update { it.copy(isKeepLoggedIn = isKeepLoggedIn) }
    }
    private fun setUsernameErrorMessageInLoginScreen(message: String) {
        _loginScreenState.update { it.copy(usernameErrorMessage = message) }
    }
    private fun setPasswordErrorMessageInLoginScreen(message: String) {
        _loginScreenState.update { it.copy(passwordErrorMessage = message) }
    }



    fun login() {

    }


    // -------------- Login Screen END --------------------

}