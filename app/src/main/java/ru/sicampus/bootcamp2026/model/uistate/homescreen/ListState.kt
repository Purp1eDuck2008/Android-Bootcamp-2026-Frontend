package ru.sicampus.bootcamp2026.model.uistate.homescreen

import ru.sicampus.bootcamp2026.domain.entities.UserEntity


sealed interface ListState {
    data class Error(val reason: String): ListState
    data object Loading: ListState
    data class Content(
        val users: List<UserEntity>
    ) : ListState
}