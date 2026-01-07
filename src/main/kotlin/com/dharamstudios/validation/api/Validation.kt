package com.dharamstudios.validation.api

import com.dharamstudios.validation.internal.ValidationScopeImpl

fun validate(
    target: Any? = null,
    block: ValidationScope.() -> Unit
): ValidationResult {

    val scope = ValidationScopeImpl(
        target = target,
    )
    scope.block()
    return if (scope.fieldErrors.isEmpty()) {
        ValidationResult.Valid
    } else {
        val errorMessages = scope.fieldErrors
        ValidationResult.Invalid(errorMessages)
    }
}