package kz.tutorial.jsonplaceholdertypicode.domain.client

import kz.tutorial.jsonplaceholdertypicode.domain.model.Comment
import kz.tutorial.jsonplaceholdertypicode.domain.model.Post

interface GetPostUseCase {
    suspend fun invoke(id:Int): Post
    suspend fun getComments(id:Int): List<Comment>
}