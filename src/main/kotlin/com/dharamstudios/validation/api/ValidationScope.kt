package com.dharamstudios.validation.api

import kotlin.reflect.KProperty1

interface ValidationScope {
    fun <T> field(
        name: String,
        value: T,
        block: FieldScope<T>.() -> Unit
    )
    fun <O, T> field(
        property: KProperty1<O, T>,
        block: FieldScope<T>.() -> Unit
    )
}