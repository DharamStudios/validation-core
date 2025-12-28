package com.dharamstudios.validation.api

import kotlin.test.Test
import kotlin.test.assertTrue


class FieldScopeTest {

    // ---------- notBlank ----------

    @Test
    fun `notBlank returns invalid when value is blank`() {
        val result = validate {
            field("username", "   ") {
                notBlank()
            }
        }
        assertTrue(result is ValidationResult.Invalid)
    }

    @Test
    fun `notBlank returns invalid when value is empty`() {
        val result = validate {
            field("username", "") {
                notBlank()
            }
        }
        assertTrue(result is ValidationResult.Invalid)
    }

    @Test
    fun `notBlank returns valid when value is non blank`() {
        val result = validate {
            field("password", "ABCD@!@#$") {
                notBlank()
            }
        }
        assertTrue(result is ValidationResult.Valid)
    }

    // ---------- minLength ----------

    @Test
    fun `minLength returns valid when value is greater than minLength`() {
        val result = validate {
            field("password", "ABCDE") {
                minLength(5)
            }
        }
        assertTrue(result is ValidationResult.Valid)
    }

    @Test
    fun `minLength returns invalid when value is less than minLength`() {
        val result = validate {
            field("password", "ABCD") {
                minLength(5)
            }
        }
        assertTrue(result is ValidationResult.Invalid)
    }

    // ---------- maxLength ----------

    @Test
    fun `maxLength returns valid when value is less than maxLength`() {
        val result = validate {
            field("password", "ABC") {
                maxLength(4)
            }
        }
        assertTrue(result is ValidationResult.Valid)
    }

    @Test
    fun `maxLength returns invalid when value is greater than maxLength`() {
        val result = validate {
            field("password", "ABCDEFG") {
                maxLength(5)
            }
        }
        assertTrue(result is ValidationResult.Invalid)
    }

    // ---------- onlyLetters ----------

    @Test
    fun `onlyLetters returns valid when value is contains only letters`() {
        val result = validate {
            field("password", "ABC") {
                onlyLetters()
            }
        }
        assertTrue(result is ValidationResult.Valid)
    }

    @Test
    fun `onlyLetters returns invalid when value is contains other than letters`() {
        val result = validate {
            field("password", "ABC@123") {
                onlyLetters()
            }
        }
        assertTrue(result is ValidationResult.Invalid)
    }

    // ---------- onlyDigits ----------

    @Test
    fun `onlyDigits returns valid when value is contains only digits`() {
        val result = validate {
            field("password", "1234") {
                onlyDigits()
            }
        }
        assertTrue(result is ValidationResult.Valid)
    }

    @Test
    fun `onlyDigits returns invalid when value is contains other than digits`() {
        val result = validate {
            field("password", "ABC@123") {
                onlyDigits()
            }
        }
        assertTrue(result is ValidationResult.Invalid)
    }
    // ---------- minValue ----------

    @Test
    fun `minValue returns valid when value is equal to atLeast`() {
        val result = validate {
            field("age", 18) {
                minValue(18)
            }
        }
        assertTrue(result is ValidationResult.Valid)
    }

    @Test
    fun `minValue returns invalid when value is less than atLeast`() {
        val result = validate {
            field("age", 16) {
                minValue(18)
            }
        }
        assertTrue(result is ValidationResult.Invalid)
    }

    // ---------- maxValue ----------

    @Test
    fun `maxValue returns valid when value is equal to atMost`() {
        val result = validate {
            field("age", 26) {
                maxValue(26)
            }
        }
        assertTrue(result is ValidationResult.Valid)
    }

    @Test
    fun `maxValue returns invalid when value is greater than atMost`() {
        val result = validate {
            field("age", 30) {
                maxValue(26)
            }
        }
        assertTrue(result is ValidationResult.Invalid)
    }

    // ---------- inRange ----------

    @Test
    fun `inRange returns valid when value is inside range`() {
        val result = validate {
            field("age", 22) {
                inRange(18, 26)
            }
        }
        assertTrue(result is ValidationResult.Valid)
    }

    @Test
    fun `inRange returns invalid when value is below range`() {
        val result = validate {
            field("age", 15) {
                inRange(18, 26)
            }
        }
        assertTrue(result is ValidationResult.Invalid)
    }

    @Test
    fun `inRange returns invalid when value is above range`() {
        val result = validate {
            field("age", 30) {
                inRange(18, 26)
            }
        }
        assertTrue(result is ValidationResult.Invalid)
    }

    // ---------- positive ----------

    @Test
    fun `positive returns valid when value is greater than zero`() {
        val result = validate {
            field("count", 5) {
                positive()
            }
        }
        assertTrue(result is ValidationResult.Valid)
    }

    @Test
    fun `positive returns invalid when value is zero`() {
        val result = validate {
            field("count", 0) {
                positive()
            }
        }
        assertTrue(result is ValidationResult.Invalid)
    }

    @Test
    fun `positive returns invalid when value is negative`() {
        val result = validate {
            field("count", -3) {
                positive()
            }
        }
        assertTrue(result is ValidationResult.Invalid)
    }

    // ---------- nonPositive ----------

    @Test
    fun `nonPositive returns valid when value is zero`() {
        val result = validate {
            field("delta", 0) {
                nonPositive()
            }
        }
        assertTrue(result is ValidationResult.Valid)
    }

    @Test
    fun `nonPositive returns valid when value is negative`() {
        val result = validate {
            field("delta", -5) {
                nonPositive()
            }
        }
        assertTrue(result is ValidationResult.Valid)
    }

    @Test
    fun `nonPositive returns invalid when value is positive`() {
        val result = validate {
            field("delta", 4) {
                nonPositive()
            }
        }
        assertTrue(result is ValidationResult.Invalid)
    }

    // ---------- nonNegative ----------

    @Test
    fun `nonNegative returns valid when value is zero`() {
        val result = validate {
            field("balance", 0) {
                nonNegative()
            }
        }
        assertTrue(result is ValidationResult.Valid)
    }

    @Test
    fun `nonNegative returns valid when value is positive`() {
        val result = validate {
            field("balance", 10) {
                nonNegative()
            }
        }
        assertTrue(result is ValidationResult.Valid)
    }

    @Test
    fun `nonNegative returns invalid when value is negative`() {
        val result = validate {
            field("balance", -2) {
                nonNegative()
            }
        }
        assertTrue(result is ValidationResult.Invalid)
    }
}