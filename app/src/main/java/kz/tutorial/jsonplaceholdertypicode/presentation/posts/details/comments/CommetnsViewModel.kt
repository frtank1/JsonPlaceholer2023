package kz.tutorial.jsonplaceholdertypicode.presentation.posts.details.comments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.tutorial.jsonplaceholdertypicode.data.client.GetCommentsUseCaseImpl
import kz.tutorial.jsonplaceholdertypicode.domain.client.GetCommentsUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.client.GetPostUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.client.GetUsersUseCase


class CommentsViewModel(private val getCommentstUseCase: GetCommentsUseCase, val id: Int):ViewModel() {

    private val _commentsDetailsLiveData: MutableLiveData<CommentsState> = MutableLiveData()
    val commentsDetailsLiveData: LiveData<CommentsState> = _commentsDetailsLiveData

    init {
        getComments()
    }

    private fun getComments() {
        _commentsDetailsLiveData.postValue(CommentsState.Loading)
        viewModelScope.launch {
            val list = getCommentstUseCase.getComments(id)

            if (list != null) {
                _commentsDetailsLiveData.postValue(CommentsState.Success(list))
            } else {
                _commentsDetailsLiveData.postValue(CommentsState.Error(error("null")))
            }
        }

    }
}