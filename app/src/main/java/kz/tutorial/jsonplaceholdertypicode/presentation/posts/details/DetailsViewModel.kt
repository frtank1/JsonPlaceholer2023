package kz.tutorial.jsonplaceholdertypicode.presentation.posts.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.tutorial.jsonplaceholdertypicode.domain.client.GetCommentsUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.client.GetPostUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.client.GetUsersUseCase
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.DefaultString


class DetailsViewModel(private val getPostUseCase: GetPostUseCase,private val getUsersUseCase: GetUsersUseCase,private val getCommentsUseCase: GetCommentsUseCase,val id: Int) : ViewModel() {

    private val _postDetailsLiveData: MutableLiveData<PostState> = MutableLiveData()
    val postDetailsLiveData: LiveData<PostState> = _postDetailsLiveData

    init {
        _postDetailsLiveData.postValue(PostState.Loading)
        getPosts()
    }

    private fun getPosts() {
        viewModelScope.launch {
            val post = getPostUseCase.invoke(id)
            val list = getCommentsUseCase.getComments(id)
            val user = getUsersUseCase.getUser(id)

            if (post != null || list != null) {
                _postDetailsLiveData.postValue(PostState.Success(list, post, user.name?:DefaultString))
            } else {
                _postDetailsLiveData.postValue(PostState.Error(error("null")))
            }
        }

    }
}