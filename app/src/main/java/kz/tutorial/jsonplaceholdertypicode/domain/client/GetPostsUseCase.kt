package kz.tutorial.jsonplaceholdertypicode.domain.client

import kz.tutorial.jsonplaceholdertypicode.domain.model.Post

interface GetPostsUseCase {
    suspend fun invoke(): List<Post>
}