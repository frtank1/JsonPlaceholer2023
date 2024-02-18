package kz.tutorial.jsonplaceholdertypicode.presentation.albums

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kz.tutorial.jsonplaceholdertypicode.domain.client.GetAlbumsUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.client.GetPhotosUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.client.GetUserUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.client.GetUsersUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.model.Album
import kz.tutorial.jsonplaceholdertypicode.domain.model.albumConvertToAlbusObject
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.FIRST

class AlbumsViewModel(
    private val getAlbumsUseCase: GetAlbumsUseCase,
    private val getPhotosUseCase: GetPhotosUseCase,
    private val getUsersUseCase: GetUsersUseCase
) : ViewModel() {

    private val _albumsLiveData: MutableLiveData<AlbumsState> = MutableLiveData()
    val albumsLiveData: LiveData<AlbumsState> = _albumsLiveData

    init {
        getAlbums()
    }

    private fun getAlbums() {
        _albumsLiveData.postValue(AlbumsState.Loading)
        viewModelScope.launch {
            try {
                val albumsDeferred = async { getAlbumsUseCase.getAlbums() }
                val photosDeferred = async { getPhotosUseCase.getPhotos() }
                val usersDeferred = async { getUsersUseCase.getUsers() }

                val albums = albumsDeferred.await()
                val photo = photosDeferred.await()
                val users = usersDeferred.await()

                val albumsObjectList = if (albums != null && photo != null) {
                    albumConvertToAlbusObject(users, photo, albums)
                } else {
                    null
                }

                _albumsLiveData.postValue(albumsObjectList?.let { AlbumsState.Success(it) } ?: AlbumsState.Error("Failed to load data"))
            } catch (e: Exception) {
                _albumsLiveData.postValue(AlbumsState.Error("An error occurred: ${e.message}"))
            }
        }
    }

}
