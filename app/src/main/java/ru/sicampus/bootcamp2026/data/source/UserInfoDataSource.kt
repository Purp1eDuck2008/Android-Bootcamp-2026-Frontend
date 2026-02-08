package ru.sicampus.bootcamp2026.data.source

import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.auth.HttpAuthHeader
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.sicampus.bootcamp2026.data.dto.UserDto

class UserInfoDataSource {
    val token = AuthLocalDataSource.token
    suspend fun getUser(): Result<List<UserDto>> = withContext(Dispatchers.IO){
        runCatching {
            val result = Network.client.get("${Network.HOST}/api/person"){
                header(HttpHeaders.Authorization, token)
            }
            if (result.status != HttpStatusCode.OK){
                error("Status: ${result.status}")
            }
            result.body()
        }
    }
}