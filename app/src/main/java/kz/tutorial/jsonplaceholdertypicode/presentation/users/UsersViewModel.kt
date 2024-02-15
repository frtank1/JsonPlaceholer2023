package kz.tutorial.jsonplaceholdertypicode.presentation.users

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.tutorial.jsonplaceholdertypicode.domain.client.GetUsersUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.model.Post
import kz.tutorial.jsonplaceholdertypicode.presentation.posts.details.PostState
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.ClickListener

class UsersViewModel(private val getUsersUseCase: GetUsersUseCase):ViewModel() {
    private val _usersLiveData: MutableLiveData<UsersState> = MutableLiveData()
    val usersLiveData: LiveData<UsersState> = _usersLiveData

    init {
        getUsers()
    }
    private fun getUsers() {
        viewModelScope.launch {
            val users = getUsersUseCase.invoke()

            if (users != null ) {
                _usersLiveData.postValue(UsersState.Success(users))
            } else {
                _usersLiveData.postValue(UsersState.Error(error("null")))
            }

        }
    }


}