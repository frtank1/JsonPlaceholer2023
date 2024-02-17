package kz.tutorial.jsonplaceholdertypicode.presentation.albums

import kz.tutorial.jsonplaceholdertypicode.domain.model.Comment
import kz.tutorial.jsonplaceholdertypicode.domain.model.Post

sealed class AlbumsState {
    data class Success(val listComment:List<Comment>, val post: Post, val name:String): AlbumsState()
    data class Error(val error: Throwable): AlbumsState()
    object Loading: AlbumsState()
}
