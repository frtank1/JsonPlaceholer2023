package kz.tutorial.jsonplaceholdertypicode.domain

interface GetPostsUseCase {
    suspend fun invoke(): List<Post>
    suspend fun getPost(id:Int): Post
}