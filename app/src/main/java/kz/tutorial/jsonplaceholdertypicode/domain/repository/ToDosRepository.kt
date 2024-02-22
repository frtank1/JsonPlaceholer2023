package kz.tutorial.jsonplaceholdertypicode.domain.repository

import kz.tutorial.jsonplaceholdertypicode.domain.model.ToDoItem

interface ToDoRepository {
    suspend fun getToDos():List<ToDoItem>
    suspend fun getToDo(userId: Int): List<ToDoItem>
}