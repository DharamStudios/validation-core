package com.dharamstudios.validation.api

data class FieldError(
    val fieldName: String,
    val message: String,
    val validationCoreErrorType: ValidationCoreError
)
