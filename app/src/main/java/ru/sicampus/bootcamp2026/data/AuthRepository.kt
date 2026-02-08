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
    ): Boolean {
        authLocalDataSource.SetToken(login, password)
        val result = authNetworkDataSource.checkAuth(
            authLocalDataSource.token ?: return false
        )
        if (!result){
            authLocalDataSource.ClearToken()
        }
        return result
    }

}