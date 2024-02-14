package kz.tutorial.jsonplaceholdertypicode.data.network


import kz.tutorial.jsonplaceholdertypicode.domain.model.Comment
import kz.tutorial.jsonplaceholdertypicode.domain.model.Post
import retrofit2.http.GET
import retrofit2.http.Path

interface MainApi {

    @GET("posts")
    suspend fun getPosts(): List<Post>

    @GET("posts/{id}")
    suspend fun getPost(@Path("id") id: Int): Post


    @GET("posts/{id}/comments")
    suspend fun getComments(@Path("id") id: Int): List<Comment>

}