package kz.tutorial.jsonplaceholdertypicode.data.client

import kz.tutorial.jsonplaceholdertypicode.domain.client.GetAlbumsUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.client.GetCommentsUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.model.Album
import kz.tutorial.jsonplaceholdertypicode.domain.model.Comment
import kz.tutorial.jsonplaceholdertypicode.domain.repository.AlbumsRepository
import kz.tutorial.jsonplaceholdertypicode.domain.repository.PostsRepository

class GetAlbumsUseCaseImpl (private val albumsRepository: AlbumsRepository): GetAlbumsUseCase {
    override suspend fun getAlbums(): List<Album> {
        return albumsRepository.getAlbums()
    }
}