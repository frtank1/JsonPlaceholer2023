package kz.tutorial.jsonplaceholdertypicode.domain.repository


import kz.tutorial.jsonplaceholdertypicode.domain.model.Photo

interface PhotosRepository {
    suspend fun getPhotos(): List<Photo>
    suspend fun getPhoto(id:Int): Photo
}