package com.example.edaramobile.authentication.domain.models

sealed class ValidationResult {
    data object SuccessValidationResult: ValidationResult()
    data class FailureValidationResult(val errorMessage: String): ValidationResult()
}
