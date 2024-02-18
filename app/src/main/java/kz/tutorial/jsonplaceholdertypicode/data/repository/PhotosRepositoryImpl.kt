package kz.tutorial.jsonplaceholdertypicode.data.repository

import kz.tutorial.jsonplaceholdertypicode.data.network.PhotosApi
import kz.tutorial.jsonplaceholdertypicode.domain.model.Photo
import kz.tutorial.jsonplaceholdertypicode.domain.repository.PhotosRepository

class PhotosRepositoryImpl(private val photoApi: PhotosApi):PhotosRepository {
    override suspend fun getPhotos(): List<Photo> {
        return photoApi.getPhotos()
    }

    override suspend fun getPhoto(id: Int): Photo {
        return photoApi.getPhoto(id)
    }
}