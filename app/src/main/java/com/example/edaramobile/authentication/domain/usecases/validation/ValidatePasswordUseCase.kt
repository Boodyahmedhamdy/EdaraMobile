package com.example.edaramobile.authentication.domain.usecases.validation

import com.example.edaramobile.authentication.domain.models.ValidationResult

class ValidatePasswordUseCase {
    operator fun invoke(password: String): ValidationResult {
        if(password.length < ValidationConstants.MIN_PASSWORD_LENGTH) {
            return ValidationResult.FailureValidationResult("password must be at least ${ValidationConstants.MIN_PASSWORD_LENGTH} characters")
        }
        if(password.length > ValidationConstants.MIN_PASSWORD_LENGTH) {
            return ValidationResult.FailureValidationResult("password must be at most ${ValidationConstants.MAX_PASSWORD_LENGTH} characters")
        }


        return ValidationResult.SuccessValidationResult
    }
}