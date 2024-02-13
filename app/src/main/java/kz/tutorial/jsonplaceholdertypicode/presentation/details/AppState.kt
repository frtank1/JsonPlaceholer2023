package kz.tutorial.jsonplaceholdertypicode.presentation.details

import kz.tutorial.jsonplaceholdertypicode.domain.model.Comment
import kz.tutorial.jsonplaceholdertypicode.domain.model.Post

sealed class AppState{
    data class Success(val listComment:List<Comment>,val post: Post):AppState()
    data class Error(val error: Throwable):AppState()
    object Loading:AppState()
}