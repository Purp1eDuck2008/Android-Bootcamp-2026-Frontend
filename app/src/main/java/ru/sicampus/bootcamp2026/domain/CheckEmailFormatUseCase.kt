package ru.sicampus.bootcamp2026.domain

import android.util.Patterns

class CheckEmailFormatUseCase{
    operator fun invoke(
        email: String
    ): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}