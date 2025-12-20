package com.dharamstudios.validation.api

class FieldScope<T>(
    val fieldName: String,
    val value: T,
    val addError: (FieldError) -> Unit
)