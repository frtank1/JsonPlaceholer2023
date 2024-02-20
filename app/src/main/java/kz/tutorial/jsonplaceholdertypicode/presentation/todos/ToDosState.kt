package kz.tutorial.jsonplaceholdertypicode.presentation.todos

import android.net.Uri
import kz.tutorial.jsonplaceholdertypicode.domain.model.User
import kz.tutorial.jsonplaceholdertypicode.presentation.users.user.UserState

sealed class ToDosState {
    data class Success(val user: User): ToDosState()
    data class Error(val error: String): ToDosState()
    object Loading: ToDosState()

    data class ShowOnMap(val address: Uri): ToDosState()
}