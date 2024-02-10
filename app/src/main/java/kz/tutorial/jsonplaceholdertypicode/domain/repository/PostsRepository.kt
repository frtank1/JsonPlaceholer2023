package kz.tutorial.jsonplaceholdertypicode.domain.repository

import kz.tutorial.jsonplaceholdertypicode.domain.model.Post

interface PostsRepository {
    suspend fun getPosts(): List<Post>
}