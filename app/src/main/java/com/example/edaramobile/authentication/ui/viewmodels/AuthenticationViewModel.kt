package com.example.edaramobile.authentication.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.edaramobile.authentication.domain.models.ValidationResult
import com.example.edaramobile.authentication.domain.usecases.validation.ValidateFirstNameUseCase
import com.example.edaramobile.authentication.domain.usecases.validation.ValidateLastNameUseCase
import com.example.edaramobile.authentication.domain.usecases.validation.ValidatePasswordUseCase
import com.example.edaramobile.authentication.ui.states.LoginScreenUiState
import com.example.edaramobile.authentication.ui.states.RegisterScreenUiState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AuthenticationViewModel(
//    private val validateFirstNameUseCase: ValidateFirstNameUseCase
): ViewModel() {


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
    fun updateFirstNameErrorMessageInRegisterScreen(firstNameErrorMessage: String) {
        _registerScreenState.update { it.copy(firstNameErrorMessage = firstNameErrorMessage) }
    }
    fun updateLastNameInRegisterScreen(lastName: String) {
        _registerScreenState.update { it.copy(lastName = lastName) }
    }
    fun updateLastNameErrorMessageInRegisterScreen(lastNameErrorMessage: String) {
        _registerScreenState.update { it.copy(lastNameErrorMessage = lastNameErrorMessage) }
    }
    fun updateUsernameInRegisterScreen(username: String) {
        _registerScreenState.update { it.copy(username = username) }
    }
    fun updateUsernameErrorMessageInRegisterScreen(usernameErrorMessage: String) {
        _registerScreenState.update { it.copy(usernameErrorMessage = usernameErrorMessage) }
    }
    fun updatePasswordInRegisterScreen(password: String) {
        _registerScreenState.update { it.copy(password = password) }
    }
    private fun updatePasswordErrorMessageInRegisterScreen(passwordErrorMessage: String) {
        _registerScreenState.update { it.copy(passwordErrorMessage = passwordErrorMessage) }
    }
    fun updateConfirmedPasswordInRegisterScreen(confirmedPassword: String) {
        _registerScreenState.update { it.copy(confirmedPassword = confirmedPassword) }
    }
    private fun updateConfirmedPasswordErrorMessageInRegisterScreen(confirmedPasswordErrorMessage: String) {
        _registerScreenState.update { it.copy(confirmedPasswordErrorMessage = confirmedPasswordErrorMessage) }
    }
    private fun updateRegisterButtonEnabledInRegisterScreen(enabled: Boolean) {
        _registerScreenState.update { it.copy(registerButtonEnabled = enabled) }
    }
    private fun updateGeneralErrorMessageInRegisterScreen(generalErrorMessage: String) {
        _registerScreenState.update { it.copy(generalErrorMessage = generalErrorMessage) }
    }

    fun register() {
        if(isValidRegisterScreenData()) {
            // register logic
            viewModelScope.launch {
                updateRegisterButtonEnabledInRegisterScreen(false)
                delay(2000) // api call delay simulation
                updateRegisterButtonEnabledInRegisterScreen(true)
            }
        }
    }


    // -------------- Register Screen END ------------------------

    // ----------------- Common Logic Start ------------------------
    private fun validateFirstName(firstName: String): Boolean {
//        val result = validateFirstNameUseCase(firstName)
        val result = ValidateFirstNameUseCase().invoke(firstName)
        return when(result) {
            is ValidationResult.FailureValidationResult -> {
                updateFirstNameErrorMessageInRegisterScreen(result.errorMessage)
                false
            }
            ValidationResult.SuccessValidationResult -> {
                updateFirstNameErrorMessageInRegisterScreen("")
                true
            }
        }
    }

    private fun validateLastName(lastName: String): Boolean {
        val result = ValidateLastNameUseCase().invoke(lastName)
        return when(result) {
            is ValidationResult.FailureValidationResult -> {
                updateLastNameErrorMessageInRegisterScreen(result.errorMessage)
                false
            }
            ValidationResult.SuccessValidationResult -> {
                updateLastNameErrorMessageInRegisterScreen("")
                true
            }
        }
    }

    private fun validatePassword(password: String): Boolean {
        val result = ValidatePasswordUseCase().invoke(password)
        return when(result) {
            is ValidationResult.FailureValidationResult -> {
                updatePasswordErrorMessageInRegisterScreen(result.errorMessage)
                false
            }
            ValidationResult.SuccessValidationResult -> {
                updatePasswordErrorMessageInRegisterScreen("")
                true
            }
        }
    }

    // no need to separate in another class where the logic won't extend any more
    // it is just a string comparison
    private fun validateConfirmedPassword(password: String, confirmedPassword: String): Boolean {
        return if(password != confirmedPassword) {
            updateConfirmedPasswordErrorMessageInRegisterScreen("confirmed password isn't the same as password")
            false
        } else {
            updateConfirmedPasswordErrorMessageInRegisterScreen("")
            true
        }
    }

    private fun isValidRegisterScreenData(): Boolean {
        return validateFirstName(registerScreenState.value.firstName)
                && validateLastName(registerScreenState.value.lastName)
                && validatePassword(registerScreenState.value.password)
                && validateConfirmedPassword(password = registerScreenState.value.password, confirmedPassword = registerScreenState.value.confirmedPassword)

    }


    // ----------------- Common Logic END ------------------------

}