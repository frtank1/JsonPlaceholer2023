package kz.tutorial.jsonplaceholdertypicode.presentation.todos

import kz.tutorial.jsonplaceholdertypicode.domain.model.ToDoItem

sealed class ToDosState {
    data class Success(val todos: List<ToDoItem>): ToDosState()
    data class Error(val error: String): ToDosState()
    object Loading: ToDosState()
}