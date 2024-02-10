package kz.tutorial.jsonplaceholdertypicode.data.network

import kz.tutorial.jsonplaceholdertypicode.domain.model.Post
import retrofit2.http.GET

interface MainApi {

    @GET("posts")
    suspend fun getPosts(): List<Post>

}