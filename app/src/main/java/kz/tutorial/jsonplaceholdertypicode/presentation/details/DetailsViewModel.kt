package kz.tutorial.jsonplaceholdertypicode.presentation.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.tutorial.jsonplaceholdertypicode.domain.client.GetPostUseCase


class DetailsViewModel(private val getPostUseCase: GetPostUseCase, val id:Int) : ViewModel(){

    private val _postDetailsLiveData: MutableLiveData<AppState> = MutableLiveData()
    val postDetailsLiveData: LiveData<AppState> = _postDetailsLiveData

    init {

    }

    private fun getPosts() {
        viewModelScope.launch {
            val posts = getPostUseCase.invoke(id)
            val list = getPostUseCase.getComments(id)

        }
    }

}