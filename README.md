# validation-core

A lightweight, type-safe validation DSL for Kotlin, designed to validate fields in a clean, readable, and composable way.

`validation-core` helps you define validation rules close to your data, collect structured errors, and keep validation logic expressive and maintainable.

---

## ✨ Features

- Declarative validation DSL
- Type-safe rules for `String` and `Int`
- Collects multiple validation errors
- No Android dependency (pure Kotlin / JVM)
- Easy to test and extend
- Clean API inspired by Kotlin idioms

---

## 📦 Installation

### Using JitPack

Add JitPack to your repositories:

```gradle
repositories {
    mavenCentral()
    maven { url = uri("https://jitpack.io") }
}
```

Add the dependency:

```gradle
dependencies {
    implementation("com.github.DharamStudios:validation-core:0.2.0")
}
```

---

## 🚀 Quick Example

```kotlin
val result = validate {
    field("username", "   ") {
        notBlank()
        minLength(3)
        maxLength(20)
    }

    field("age", 16) {
        inRange(18, 26)
    }
}

println(result)
```

### Output

```text
Invalid(messages=[
  FieldError(fieldName=username, message=Field username is blank),
  FieldError(fieldName=age, message=Field age should be in between 18 and 26)
])
```

---

## 🧩 String Validators

Available string validation rules:

- `notBlank()`
- `minLength(length)`
- `maxLength(length)`
- `onlyLetters()`
- `onlyDigits()`

### Example

```kotlin
field("password", "ABC123") {
    notBlank()
    minLength(6)
}
```

---

## 🔢 Int Validators

Available integer validation rules:

- `minValue(atLeast)`
- `maxValue(atMost)`
- `inRange(from, to)`
- `positive()`
- `nonPositive()`
- `nonNegative()`

### Example

```kotlin
field("count", 5) {
    positive()
}
```

---

## 🧪 Testing

The library includes comprehensive unit tests for:

- String validators
- Int validators
- Edge cases
- Multiple rules per field

All tests are written using `kotlin.test` and run with the JUnit Platform.

---

## 🏗 Design Philosophy

- Validation rules describe **constraints**, not behavior
- Errors are **collected**, not thrown
- DSL should read naturally inside a `field {}` block
- Prefer small, composable rules over complex validators

---

## 📄 License

This project is licensed under the **Apache License 2.0**.  
See the `LICENSE.txt` file for details.

---

## 👤 Author

**Dharam Studios**

---

## 🌱 Roadmap

- Optional / conditional validations
- Cross-field validation support
- Improved error customization

---

## ⭐ Contributing

Contributions, issues, and feature requests are welcome.  
Feel free to open an issue or submit a pull request.
