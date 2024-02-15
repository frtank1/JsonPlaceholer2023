package kz.tutorial.jsonplaceholdertypicode.presentation.comments

import kz.tutorial.jsonplaceholdertypicode.domain.model.Comment
import kz.tutorial.jsonplaceholdertypicode.domain.model.Post

sealed class CommentsState{
    data class Success(val listComment:List<Comment>):CommentsState()
    data class Error(val error: Throwable):CommentsState()
    object Loading:CommentsState()
}
