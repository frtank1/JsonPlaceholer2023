package kz.tutorial.jsonplaceholdertypicode.presentation.albums.photo_user

import kz.tutorial.jsonplaceholdertypicode.domain.model.AlbumsObject
import kz.tutorial.jsonplaceholdertypicode.domain.model.Photo

sealed class PhotoState {
    data class Success(val listPhoto:List<Photo>): PhotoState()
    data class Error(val error: String): PhotoState()

    data class changeLayout(val layout:LayoutStatus):PhotoState()
    object Loading: PhotoState()
}

enum class LayoutStatus {
    LinerLayout,
    GridLayout
}
