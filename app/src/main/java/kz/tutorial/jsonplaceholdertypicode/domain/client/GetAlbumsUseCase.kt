package kz.tutorial.jsonplaceholdertypicode.domain.client

import kz.tutorial.jsonplaceholdertypicode.domain.model.Album
import kz.tutorial.jsonplaceholdertypicode.domain.model.Comment

interface GetAlbumsUseCase {
    suspend fun getAlbums(): List<Album>

}