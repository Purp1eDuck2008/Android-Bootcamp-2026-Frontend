package ru.sicampus.bootcamp2026.domain.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class UserEntity(

    val name: String,
    val email: String,
    val photoUrl: String,

)