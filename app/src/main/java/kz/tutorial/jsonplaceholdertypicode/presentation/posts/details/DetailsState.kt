package kz.tutorial.jsonplaceholdertypicode.presentation.posts.details

import kz.tutorial.jsonplaceholdertypicode.domain.model.Comment
import kz.tutorial.jsonplaceholdertypicode.domain.model.Post

sealed class PostState{
    data class Success(val listComment:List<Comment>,val post: Post, val name:String): PostState()
    data class Error(val error: Throwable): PostState()
    object Loading: PostState()
}
