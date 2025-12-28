package com.dharamstudios.validation.internal

import com.dharamstudios.validation.api.FieldError
import com.dharamstudios.validation.api.FieldScope
import com.dharamstudios.validation.api.ValidationScope

internal class ValidationScopeImpl : ValidationScope {
    private val _fieldErrors = mutableListOf<FieldError>()
    internal val fieldErrors: List<FieldError>
        get() = _fieldErrors.toList()

    override fun <T> field(
        name: String,
        value: T,
        block: FieldScope<T>.() -> Unit
    ) {
        FieldScope(
            fieldName = name,
            value = value,
            addError = {
                _fieldErrors.add(it)
            }
        ).block()
    }
}