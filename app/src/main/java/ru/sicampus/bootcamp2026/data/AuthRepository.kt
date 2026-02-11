package ru.sicampus.bootcamp2026.data

import ru.sicampus.bootcamp2026.data.source.AuthLocalDataSource
import ru.sicampus.bootcamp2026.data.source.AuthNetworkDataSource

class AuthRepository(
    private val authNetworkDataSource: AuthNetworkDataSource,
    private val authLocalDataSource: AuthLocalDataSource
) {
    suspend fun checkAndAuth(
        login: String,
        password: String,
    ): Result<Boolean> {
        authLocalDataSource.SetToken(login, password)
        return authNetworkDataSource.checkAuth(
            authLocalDataSource.getToken() ?: return Result.success(false)
        )
            .onSuccess{ isLogin ->
                if(!isLogin) authLocalDataSource.ClearToken()
        }
            .onFailure{
                authLocalDataSource.ClearToken()
        }
    }

}