package kz.tutorial.jsonplaceholdertypicode.presentation.posts

import android.os.Bundle
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.tutorial.jsonplaceholdertypicode.domain.client.GetPostsUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.model.Post

class PostsViewModel(private val getPostsUseCase: GetPostsUseCase) : ViewModel() {

    private val _postsLiveData: MutableLiveData<List<Post>> = MutableLiveData()
    val postsLiveData: LiveData<List<Post>> = _postsLiveData

    init {
        getPosts()
    }

    private fun getPosts() {
        viewModelScope.launch {
            val posts = getPostsUseCase.invoke()
            _postsLiveData.postValue(posts)
        }
    }


}