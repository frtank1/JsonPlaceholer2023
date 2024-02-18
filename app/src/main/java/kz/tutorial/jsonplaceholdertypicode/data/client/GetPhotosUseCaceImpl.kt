package kz.tutorial.jsonplaceholdertypicode.data.client

import kz.tutorial.jsonplaceholdertypicode.domain.client.GetPhotosUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.model.Photo
import kz.tutorial.jsonplaceholdertypicode.domain.repository.PhotosRepository

class GetPhotosUseCaseImpl(private val photosRepository: PhotosRepository):GetPhotosUseCase {
    override suspend fun getPhotos(): List<Photo> {
        return photosRepository.getPhotos()
    }

    override suspend fun getPhoto(id:Int): Photo {
        return photosRepository.getPhoto(id)
    }
}