package kz.tutorial.jsonplaceholdertypicode.domain

import kz.tutorial.jsonplaceholdertypicode.domain.Post

interface PostsRepository {
    suspend fun getPosts(): List<Post>
    suspend fun getPost(id:Int): Post
}