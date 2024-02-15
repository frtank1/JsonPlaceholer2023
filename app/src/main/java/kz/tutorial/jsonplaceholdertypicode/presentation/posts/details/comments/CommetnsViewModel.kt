package kz.tutorial.jsonplaceholdertypicode.presentation.posts.details.comments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.tutorial.jsonplaceholdertypicode.domain.client.GetPostUseCase


class CommentsViewModel(private val getPostUseCase: GetPostUseCase, val id: Int):ViewModel() {

    private val _commentsDetailsLiveData: MutableLiveData<CommentsState> = MutableLiveData()
    val commentsDetailsLiveData: LiveData<CommentsState> = _commentsDetailsLiveData

    init {
        getComments()
    }

    private fun getComments() {
        viewModelScope.launch {
            val list = getPostUseCase.getComments(id)

            if (list != null) {
                _commentsDetailsLiveData.postValue(CommentsState.Success(list))
            } else {
                _commentsDetailsLiveData.postValue(CommentsState.Error(error("null")))
            }
        }

    }
}