package kz.tutorial.jsonplaceholdertypicode.data.network

import kz.tutorial.jsonplaceholdertypicode.domain.model.User
import retrofit2.http.GET
import retrofit2.http.Path

interface UsersApi {
    @GET("users")
    suspend fun getUsers():List<User>

    @GET("users/{id}")
    suspend fun getUser(@Path("id") id: Int): User

}