package com.dharamstudios.validation.api

sealed interface ValidationResult {
    data object Valid: ValidationResult
    data class Invalid(val messages: List<FieldError>): ValidationResult
}