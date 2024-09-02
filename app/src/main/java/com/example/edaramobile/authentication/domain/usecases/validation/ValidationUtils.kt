package com.example.edaramobile.authentication.domain.usecases.validation

fun isStringOnlyCharacters(input: String): Boolean {
    return input.all { it.isLetter() }
}