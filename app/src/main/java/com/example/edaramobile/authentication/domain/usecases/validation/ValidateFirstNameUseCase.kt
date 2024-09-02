package com.example.edaramobile.authentication.domain.usecases.validation

import com.example.edaramobile.authentication.domain.models.ValidationResult

class ValidateFirstNameUseCase {

    operator fun invoke(firstname: String): ValidationResult {
        // length must be between 3 and 50
        if(firstname.length < ValidationConstants.MIN_FIRST_NAME_LENGTH) {
            return ValidationResult.FailureValidationResult("first name must be at least ${ValidationConstants.MIN_FIRST_NAME_LENGTH} characters")
        }
        if(firstname.length > ValidationConstants.MAX_FIRST_NAME_LENGTH) {
            return ValidationResult.FailureValidationResult("first name must be at most ${ValidationConstants.MAX_FIRST_NAME_LENGTH} characters")
        }
        // it must be only letters
        if(!isStringOnlyCharacters(firstname)) {
            return ValidationResult.FailureValidationResult("first name must contain letters only")
        }

        return ValidationResult.SuccessValidationResult
    }

}