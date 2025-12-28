package com.dharamstudios.validation.api

fun FieldScope<String>.notBlank(
    errorMessage: String? = null,
) {
    if (value.isBlank()) {
        addError(
            FieldError(
                fieldName = fieldName,
                message = errorMessage ?: "Field $fieldName is blank"
            )
        )
    }
}

fun FieldScope<String>.minLength(
    minLength: Int,
    errorMessage: String? = null,
) {
    if (value.length < minLength) {
        addError(
            FieldError(
                fieldName = fieldName,
                message = errorMessage ?: "Field $fieldName should be at least $minLength characters"
            )
        )
    }
}

fun FieldScope<String>.maxLength(
    maxLength: Int,
    errorMessage: String? = null
) {
    if (value.length > maxLength) {
        addError(
            FieldError(
                fieldName = fieldName,
                message = errorMessage ?: "Field $fieldName should be at most $maxLength characters"
            )
        )
    }
}

fun FieldScope<String>.onlyLetters(
    errorMessage: String? = null
) {
    if (value.toCharArray().none { !it.isLetter() }.not()) {
        addError(
            FieldError(
                fieldName = fieldName,
                message = errorMessage ?: "Field $fieldName should be only letters"
            )
        )
    }
}

fun FieldScope<String>.onlyDigits(
    errorMessage: String? = null
) {
    if (value.toCharArray().none {!it.isDigit() }.not()) {
        addError(
            FieldError(
                fieldName = fieldName,
                message = errorMessage ?: "Field $fieldName should contain only digits"
            )
        )
    }
}

fun FieldScope<Int>.minValue(
    atLeast: Int,
    errorMessage: String? = null
) {
    if (value < atLeast) {
        addError(
            FieldError(
                fieldName = fieldName,
                message = errorMessage ?: "Field $fieldName should be at least $atLeast"
            )
        )
    }
}

fun FieldScope<Int>.maxValue(
    atMost: Int,
    errorMessage: String? = null
) {
    if (value > atMost) {
        addError(
            FieldError(
                fieldName = fieldName,
                message = errorMessage ?: "Field $fieldName should be at most $atMost"
            )
        )
    }
}

fun FieldScope<Int>.inRange(
    from: Int,
    to: Int,
    errorMessage: String? = null
) {
    if (value !in from..to) {
        addError(
            FieldError(
                fieldName = fieldName,
                message = errorMessage ?: "Field $fieldName should be in between $from and $to"
            )
        )
    }
}

fun FieldScope<Int>.positive(
    errorMessage: String? = null
) {
    if (value <= 0) {
        addError(
            FieldError(
                fieldName = fieldName,
                message = errorMessage ?: "Field $fieldName should be positive"
            )
        )
    }
}

fun FieldScope<Int>.nonPositive(
    errorMessage: String? = null
) {
    if (value > 0) {
        addError(
            FieldError(
                fieldName = fieldName,
                message = errorMessage ?: "Field $fieldName should be non-positive"
            )
        )
    }
}

fun FieldScope<Int>.nonNegative(
    errorMessage: String? = null
) {
    if (value < 0) {
        addError(
            FieldError(
                fieldName = fieldName,
                message = errorMessage ?: "Field $fieldName should be non-negative"
            )
        )
    }
}