package kz.tutorial.jsonplaceholdertypicode.presentation.albums

import kz.tutorial.jsonplaceholdertypicode.domain.model.Album
import kz.tutorial.jsonplaceholdertypicode.domain.model.AlbumsObject
import kz.tutorial.jsonplaceholdertypicode.domain.model.Comment
import kz.tutorial.jsonplaceholdertypicode.domain.model.Post

sealed class AlbumsState {
    data class Success(val listAlbums:List<AlbumsObject>): AlbumsState()
    data class Error(val error: String): AlbumsState()
    object Loading: AlbumsState()
}
