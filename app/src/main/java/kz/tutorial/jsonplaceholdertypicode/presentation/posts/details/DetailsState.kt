package kz.tutorial.jsonplaceholdertypicode.presentation.posts.details

import kz.tutorial.jsonplaceholdertypicode.domain.model.Comment
import kz.tutorial.jsonplaceholdertypicode.domain.model.Post

sealed class Detailstate{
    data class Success(val listComment:List<Comment>,val post: Post, val name:String): Detailstate()
    data class Error(val error: Throwable): Detailstate()
    object Loading: Detailstate()
}
