package kz.tutorial.jsonplaceholdertypicode.domain.client

import kz.tutorial.jsonplaceholdertypicode.domain.model.ToDoItem

interface GetTodoUseCase {
    suspend fun getTodo(userId:Int): List<ToDoItem>

}