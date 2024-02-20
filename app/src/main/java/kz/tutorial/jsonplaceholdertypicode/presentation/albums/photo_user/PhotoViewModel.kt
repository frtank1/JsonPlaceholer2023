package kz.tutorial.jsonplaceholdertypicode.presentation.albums.photo_user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.tutorial.jsonplaceholdertypicode.domain.client.GetPhotosUseCase

class PhotoViewModel(
    private val getPhotosUseCase: GetPhotosUseCase,
    private val id_album: Int
    ):ViewModel() {

    private val _photoLiveData: MutableLiveData<PhotoState> = MutableLiveData()
    val photoLiveData: LiveData<PhotoState> = _photoLiveData
    init {
        getPhoto()
    }

    private fun getPhoto() {
        _photoLiveData.postValue(PhotoState.Loading)
        viewModelScope.launch {
            try {
                val photos= getPhotosUseCase.getPhotos()

                val photoList = if (photos != null) {
                    photos.filter { it.albumId ==  id_album }
                } else {
                    null
                }

                _photoLiveData.postValue(photoList?.let { PhotoState.Success(it) } ?: PhotoState.Error("Failed to load data"))
            } catch (e: Exception) {
                _photoLiveData.postValue(PhotoState.Error("An error occurred: ${e.message}"))
            }
        }
    }

    fun updateLayout(liner:LayoutStatus){
        _photoLiveData.postValue(PhotoState.changeLayout(liner))
    }
}