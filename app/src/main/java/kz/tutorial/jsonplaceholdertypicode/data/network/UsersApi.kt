package kz.tutorial.jsonplaceholdertypicode.data.network

import kz.tutorial.jsonplaceholdertypicode.domain.model.User
import retrofit2.http.GET

interface UsersApi {
    @GET("users")
    suspend fun getUsers():List<User>

}