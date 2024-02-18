package kz.tutorial.jsonplaceholdertypicode.presentation.posts.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.tutorial.jsonplaceholdertypicode.domain.client.GetCommentsUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.client.GetPostUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.client.GetUserUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.client.GetUsersUseCase
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.DEFAULT_STRING


class DetailsViewModel(private val getPostUseCase: GetPostUseCase, private val getUsersUseCase: GetUserUseCase, private val getCommentsUseCase: GetCommentsUseCase, val id: Int) : ViewModel() {

    private val _postDetailsLiveData: MutableLiveData<Detailstate> = MutableLiveData()
    val postDetailsLiveData: LiveData<Detailstate> = _postDetailsLiveData

    init {
        _postDetailsLiveData.postValue(Detailstate.Loading)
        getPosts()
    }

    private fun getPosts() {
        viewModelScope.launch {
            val post = getPostUseCase.invoke(id)
            val list = getCommentsUseCase.getComments(id)
            val user = getUsersUseCase.getUser(id)

            if (post != null || list != null) {
                _postDetailsLiveData.postValue(Detailstate.Success(list, post, user.name?:DEFAULT_STRING))
            } else {
                _postDetailsLiveData.postValue(Detailstate.Error(error("null")))
            }
        }

    }
}