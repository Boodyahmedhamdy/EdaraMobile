package com.example.edaramobile.authentication.domain.usecases.validation

import com.example.edaramobile.authentication.domain.models.ValidationResult

class ValidateLastNameUseCase {

    operator fun invoke(lastname: String): ValidationResult {
        // length must be between 3 and 50
        if(lastname.length < ValidationConstants.MIN_LAST_NAME_LENGTH) {
            return ValidationResult.FailureValidationResult("last name must be at least ${ValidationConstants.MIN_LAST_NAME_LENGTH} characters")
        }
        if(lastname.length > ValidationConstants.MAX_LAST_NAME_LENGTH) {
            return ValidationResult.FailureValidationResult("last name must be at most ${ValidationConstants.MAX_LAST_NAME_LENGTH} characters")
        }
        // it must be only letters
        if(!isStringOnlyCharacters(lastname)) {
            return ValidationResult.FailureValidationResult("last name must contain letters only")
        }

        return ValidationResult.SuccessValidationResult
    }
}