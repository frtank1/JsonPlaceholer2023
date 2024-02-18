package kz.tutorial.jsonplaceholdertypicode.presentation.albums.photo_user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kz.tutorial.jsonplaceholdertypicode.presentation.albums.AlbumsState

class PhotoViewModel():ViewModel() {

    private val _albumsLiveData: MutableLiveData<AlbumsState> = MutableLiveData()
    val albumsLiveData: LiveData<AlbumsState> = _albumsLiveData

}