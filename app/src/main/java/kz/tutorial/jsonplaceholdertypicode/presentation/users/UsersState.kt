package kz.tutorial.jsonplaceholdertypicode.presentation.users

import kz.tutorial.jsonplaceholdertypicode.domain.model.User

sealed class UsersState{
    data class Success(val listUsers:List<User>): UsersState()
    data class Error(val error: Throwable): UsersState()
    object Loading: UsersState()
}
