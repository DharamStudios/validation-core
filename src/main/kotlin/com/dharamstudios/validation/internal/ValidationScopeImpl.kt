package com.dharamstudios.validation.internal

import com.dharamstudios.validation.api.FieldError
import com.dharamstudios.validation.api.FieldScope
import com.dharamstudios.validation.api.ValidationScope

internal class ValidationScopeImpl : ValidationScope {

    internal val fieldErrors = mutableListOf<FieldError>()

    override fun <T> field(
        name: String,
        value: T,
        block: FieldScope<T>.() -> Unit
    ) {
        FieldScope(
            fieldName = name,
            value = value,
            addError = { fieldErrors.add(it) }
        ).block()
    }
}