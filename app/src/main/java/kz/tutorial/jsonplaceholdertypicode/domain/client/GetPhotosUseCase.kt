package kz.tutorial.jsonplaceholdertypicode.domain.client


import kz.tutorial.jsonplaceholdertypicode.domain.model.Photo
import java.net.IDN


interface GetPhotosUseCase {
    suspend fun getPhotos(): List<Photo>
    suspend fun getPhoto(id:Int): Photo
}