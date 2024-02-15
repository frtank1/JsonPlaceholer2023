package kz.tutorial.jsonplaceholdertypicode.presentation.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.tutorial.jsonplaceholdertypicode.domain.client.GetPostUseCase


class DetailsViewModel(private val getPostUseCase: GetPostUseCase, val id: Int) : ViewModel() {

    private val _postDetailsLiveData: MutableLiveData<PostState> = MutableLiveData()
    val postDetailsLiveData: LiveData<PostState> = _postDetailsLiveData

    init {
        _postDetailsLiveData.postValue(PostState.Loading)
        getPosts()
    }

    private fun getPosts() {
        viewModelScope.launch {
            val post = getPostUseCase.invoke(id)
            val list = getPostUseCase.getComments(id)

            if (post != null || list != null) {
                _postDetailsLiveData.postValue(PostState.Success(list, post))
            } else {
                _postDetailsLiveData.postValue(PostState.Error(error("null")))
            }
        }

    }
}