package kz.tutorial.jsonplaceholdertypicode.data.network

import kz.tutorial.jsonplaceholdertypicode.domain.model.ToDoItem
import kz.tutorial.jsonplaceholdertypicode.domain.model.User
import retrofit2.http.GET
import retrofit2.http.Path

interface ToDoApi {
    @GET("todos")
    suspend fun getTodos():List<ToDoItem>
}