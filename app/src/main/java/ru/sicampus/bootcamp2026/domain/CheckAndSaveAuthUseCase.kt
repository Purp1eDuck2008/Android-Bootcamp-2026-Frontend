package ru.sicampus.bootcamp2026.domain

import ru.sicampus.bootcamp2026.data.AuthRepository

class CheckAndSaveAuthUseCase(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(
        login: String,
        password: String
    ): Result<Unit> {
        return authRepository.checkAndAuth(login, password).mapCatching { isLogin ->
            if (!isLogin) error("Неверный логин или пароль")
        }
    }
}