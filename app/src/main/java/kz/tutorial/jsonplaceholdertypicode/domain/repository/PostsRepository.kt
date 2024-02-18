package kz.tutorial.jsonplaceholdertypicode.domain.repository

import kz.tutorial.jsonplaceholdertypicode.domain.model.Comment
import kz.tutorial.jsonplaceholdertypicode.domain.model.Post

interface PostsRepository {
    suspend fun getPosts(): List<Post>
    suspend fun getPost(id:Int): Post
    suspend fun getComments(id:Int):List<Comment>
}