package kz.tutorial.jsonplaceholdertypicode.presentation.users.user

import kz.tutorial.jsonplaceholdertypicode.domain.model.User

sealed class UserState{
    data class Success(val user: User): UserState()
    data class Error(val error: Throwable): UserState()
    object Loading: UserState()
}