package kz.tutorial.jsonplaceholdertypicode.presentation.users.user

import android.net.Uri
import kz.tutorial.jsonplaceholdertypicode.domain.model.User

sealed class UserState{
    data class Success(val user: User): UserState()
    data class Error(val error: String): UserState()
    object Loading: UserState()

    data class ShowOnMap(val address: Uri):UserState()
}