package com.dharamstudios.validation.internal

import com.dharamstudios.validation.api.FieldError
import com.dharamstudios.validation.api.FieldScope
import com.dharamstudios.validation.api.ValidationScope
import kotlin.reflect.KProperty1

internal class ValidationScopeImpl (
    private val target: Any? = null
) : ValidationScope {
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

    override fun <O, T> field(
        property: KProperty1<O, T>,
        block: FieldScope<T>.() -> Unit
    ) {
        val actualTarget = target
            ?: error(
                "Property-based validation requires an owner. Use validate(owner) { ... }"
            )
        @Suppress("UNCHECKED_CAST")
        val typedOwner = actualTarget as O
        field(
            name = property.name,
            value = property.get(typedOwner),
            block = block
        )
    }
}