package kz.tutorial.jsonplaceholdertypicode.presentation.todos

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.tutorial.jsonplaceholdertypicode.domain.client.GetTodoUseCase
import kz.tutorial.jsonplaceholdertypicode.presentation.users.user.UserState

class ToDosViewModel(private val getTodoUseCase: GetTodoUseCase, private val id:Int): ViewModel() {
    private val _todoListLiveData: MutableLiveData<ToDosState> = MutableLiveData()
    val todoListLiveData: LiveData<ToDosState> = _todoListLiveData
    private lateinit var  address: Uri
    init {
        getTodos()
    }
    private fun getTodos() {
        viewModelScope.launch {
            _todoListLiveData.value = ToDosState.Success(getTodoUseCase.getTodo(id))
    }
}
}