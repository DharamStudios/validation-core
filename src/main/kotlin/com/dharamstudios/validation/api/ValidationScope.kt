package com.dharamstudios.validation.api

interface ValidationScope {
    fun <T> field(
        name: String,
        value: T,
        block: FieldScope<T>.() -> Unit
    )
}