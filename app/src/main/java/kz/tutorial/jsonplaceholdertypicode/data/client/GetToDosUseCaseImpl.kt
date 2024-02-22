package kz.tutorial.jsonplaceholdertypicode.data.client

import kz.tutorial.jsonplaceholdertypicode.domain.client.GetTodoUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.model.ToDoItem
import kz.tutorial.jsonplaceholdertypicode.domain.repository.ToDoRepository

class GetToDosUseCaseImpl(private val todosRepository: ToDoRepository) : GetTodoUseCase {

    override suspend fun getTodo(userId: Int): List<ToDoItem> {
        return todosRepository.getToDo(userId)
    }
}