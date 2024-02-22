package kz.tutorial.jsonplaceholdertypicode.data.repository



import kz.tutorial.jsonplaceholdertypicode.data.network.ToDoApi
import kz.tutorial.jsonplaceholdertypicode.domain.model.ToDoItem
import kz.tutorial.jsonplaceholdertypicode.domain.repository.ToDoRepository

class ToDoRepositoryImpl(private val toDoApi: ToDoApi): ToDoRepository{

    override suspend fun getToDos(): List<ToDoItem> {
        return toDoApi.getTodos()
    }

    override suspend fun getToDo(userId: Int): List<ToDoItem> {
        return getToDos().filter { it.userId==userId }
    }
}