package com.dharamstudios.validation.api

fun  FieldScope<String>.notBlank(
    errorMessage: String? = null,
    validationCoreErrorType: ValidationCoreError? = null
) {
    if (value.isBlank()) {
        addError(
            FieldError(
                fieldName = fieldName,
                message = errorMessage ?: "Field $fieldName is blank",
                validationCoreErrorType = validationCoreErrorType ?: DefaultValidationCoreErrorType.NONE
            )
        )
    }
}

fun FieldScope<String>.minLength(
    minLength: Int,
    errorMessage: String? = null,
    validationCoreErrorType: ValidationCoreError? = null
) {
    if (value.length < minLength) {
        addError(
            FieldError(
                fieldName = fieldName,
                message = errorMessage ?: "Field $fieldName should be at least $minLength characters",
                validationCoreErrorType = validationCoreErrorType ?: DefaultValidationCoreErrorType.NONE
            )
        )
    }
}

fun FieldScope<String>.maxLength(
    maxLength: Int,
    errorMessage: String? = null,
    validationCoreErrorType: ValidationCoreError? = null
) {
    if (value.length > maxLength) {
        addError(
            FieldError(
                fieldName = fieldName,
                message = errorMessage ?: "Field $fieldName should be at most $maxLength characters",
                validationCoreErrorType = validationCoreErrorType ?: DefaultValidationCoreErrorType.NONE
            )
        )
    }
}

fun FieldScope<String>.onlyLetters(
    errorMessage: String? = null,
    validationCoreErrorType: ValidationCoreError? = null
) {
    if (value.toCharArray().none { !it.isLetter() }.not()) {
        addError(
            FieldError(
                fieldName = fieldName,
                message = errorMessage ?: "Field $fieldName should be only letters",
                validationCoreErrorType = validationCoreErrorType ?: DefaultValidationCoreErrorType.NONE
            )
        )
    }
}

fun FieldScope<String>.onlyDigits(
    errorMessage: String? = null,
    validationCoreErrorType: ValidationCoreError? = null
) {
    if (value.toCharArray().none {!it.isDigit() }.not()) {
        addError(
            FieldError(
                fieldName = fieldName,
                message = errorMessage ?: "Field $fieldName should contain only digits",
                validationCoreErrorType = validationCoreErrorType ?: DefaultValidationCoreErrorType.NONE
            )
        )
    }
}

fun FieldScope<String>.contains(
    vararg required: String,
    errorMessage: String? = null,
    validationCoreErrorType: ValidationCoreError? = null
) {
    val missing = required.filterNot { value.contains(it) }

    if (missing.isNotEmpty()) {
        addError(
            FieldError(
                fieldName = fieldName,
                message = errorMessage
                    ?: "Field $fieldName should contain ${missing.joinToString(", ")}",
                validationCoreErrorType = validationCoreErrorType ?: DefaultValidationCoreErrorType.NONE
            )
        )
    }
}

fun FieldScope<String>.contains(
    regex: Regex,
    errorMessage: String? = null,
    validationCoreErrorType: ValidationCoreError? = null
) {
    if (!value.contains(regex)) {
        addError(
            FieldError(
                fieldName = fieldName,
                message = errorMessage
                    ?: "Field $fieldName should contain ${regex.pattern}",
                validationCoreErrorType = validationCoreErrorType ?: DefaultValidationCoreErrorType.NONE
            )
        )
    }
}

fun FieldScope<Int>.minValue(
    atLeast: Int,
    errorMessage: String? = null,
    validationCoreErrorType: ValidationCoreError? = null
) {
    if (value < atLeast) {
        addError(
            FieldError(
                fieldName = fieldName,
                message = errorMessage ?: "Field $fieldName should be at least $atLeast",
                validationCoreErrorType = validationCoreErrorType ?: DefaultValidationCoreErrorType.NONE
            )
        )
    }
}

fun FieldScope<Int>.maxValue(
    atMost: Int,
    errorMessage: String? = null,
    validationCoreErrorType: ValidationCoreError? = null
) {
    if (value > atMost) {
        addError(
            FieldError(
                fieldName = fieldName,
                message = errorMessage ?: "Field $fieldName should be at most $atMost",
                validationCoreErrorType = validationCoreErrorType ?: DefaultValidationCoreErrorType.NONE
            )
        )
    }
}

fun FieldScope<Int>.inRange(
    from: Int,
    to: Int,
    errorMessage: String? = null,
    validationCoreErrorType: ValidationCoreError? = null
) {
    if (value !in from..to) {
        addError(
            FieldError(
                fieldName = fieldName,
                message = errorMessage ?: "Field $fieldName should be in between $from and $to",
                validationCoreErrorType = validationCoreErrorType ?: DefaultValidationCoreErrorType.NONE
            )
        )
    }
}

fun FieldScope<Int>.positive(
    errorMessage: String? = null,
    validationCoreErrorType: ValidationCoreError? = null
) {
    if (value <= 0) {
        addError(
            FieldError(
                fieldName = fieldName,
                message = errorMessage ?: "Field $fieldName should be positive",
                validationCoreErrorType = validationCoreErrorType ?: DefaultValidationCoreErrorType.NONE
            )
        )
    }
}

fun FieldScope<Int>.nonPositive(
    errorMessage: String? = null,
    validationCoreErrorType: ValidationCoreError? = null
) {
    if (value > 0) {
        addError(
            FieldError(
                fieldName = fieldName,
                message = errorMessage ?: "Field $fieldName should be non-positive",
                validationCoreErrorType = validationCoreErrorType ?: DefaultValidationCoreErrorType.NONE
            )
        )
    }
}

fun FieldScope<Int>.nonNegative(
    errorMessage: String? = null,
    validationCoreErrorType: ValidationCoreError? = null
) {
    if (value < 0) {
        addError(
            FieldError(
                fieldName = fieldName,
                message = errorMessage ?: "Field $fieldName should be non-negative",
                validationCoreErrorType = validationCoreErrorType ?: DefaultValidationCoreErrorType.NONE
            )
        )
    }
}