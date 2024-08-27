package com.example.edaramobile.authentication.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.edaramobile.authentication.ui.states.LoginScreenUiState
import com.example.edaramobile.authentication.ui.states.RegisterScreenUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AuthenticationViewModel: ViewModel() {


    // -------------- Login Screen START --------------------
    private val _loginScreenState: MutableStateFlow<LoginScreenUiState> = MutableStateFlow(LoginScreenUiState())
    val loginScreenState = _loginScreenState.asStateFlow()


    fun updateUsernameInLoginScreen(username: String) {
        _loginScreenState.update { it.copy(username = username) }
    }
    fun updatePasswordInLoginScreen(password: String) {
        _loginScreenState.update { it.copy(password = password) }
    }
    fun updateIsKeepLoggedInInLoginScreen(isKeepLoggedIn: Boolean) {
        _loginScreenState.update { it.copy(isKeepLoggedIn = isKeepLoggedIn) }
    }
    private fun updateUsernameErrorMessageInLoginScreen(message: String) {
        _loginScreenState.update { it.copy(usernameErrorMessage = message) }
    }
    private fun updatePasswordErrorMessageInLoginScreen(message: String) {
        _loginScreenState.update { it.copy(passwordErrorMessage = message) }
    }



    fun login() {

    }


    // -------------- Login Screen END --------------------



    // -------------- Register Screen START ------------------------
    private val _registerScreenState: MutableStateFlow<RegisterScreenUiState> = MutableStateFlow(RegisterScreenUiState())
    val registerScreenState = _registerScreenState.asStateFlow()

    fun updateFirstNameInRegisterScreen(firstName: String) {
        _registerScreenState.update { it.copy(firstName = firstName) }
    }
    fun updateLastNameInRegisterScreen(lastName: String) {
        _registerScreenState.update { it.copy(lastName = lastName) }
    }
    fun updateUsernameInRegisterScreen(username: String) {
        _registerScreenState.update { it.copy(username = username) }
    }
    fun updatePasswordInRegisterScreen(password: String) {
        _registerScreenState.update { it.copy(password = password) }
    }
    fun updateConfirmedPasswordInRegisterScreen(confirmedPassword: String) {
        _registerScreenState.update { it.copy(confirmedPassword = confirmedPassword) }
    }
    private fun updatePasswordErrorMessageInRegisterScreen(passwordErrorMessage: String) {
        _registerScreenState.update { it.copy(passwordErrorMessage = passwordErrorMessage) }
    }
    private fun updateConfirmedPasswordErrorMessageInRegisterScreen(confirmedPasswordErrorMessage: String) {
        _registerScreenState.update { it.copy(confirmedPasswordErrorMessage = confirmedPasswordErrorMessage) }
    }
    private fun updateGeneralErrorMessageInRegisterScreen(generalErrorMessage: String) {
        _registerScreenState.update { it.copy(generalErrorMessage = generalErrorMessage) }
    }

    fun register() {

    }


    // -------------- Register Screen END ------------------------

}