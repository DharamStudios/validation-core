package com.dharamstudios.validation.api

fun FieldScope<String>.notBlank() {
    if (value.isBlank()) {
        addError(
            FieldError(
                fieldName = fieldName,
                message = "Field $fieldName is blank"
            )
        )
    }
}