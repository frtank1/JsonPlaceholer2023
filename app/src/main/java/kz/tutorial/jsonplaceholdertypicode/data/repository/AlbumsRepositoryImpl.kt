package kz.tutorial.jsonplaceholdertypicode.data.repository

import kz.tutorial.jsonplaceholdertypicode.data.network.AlbumsApi
import kz.tutorial.jsonplaceholdertypicode.data.network.PostsApi
import kz.tutorial.jsonplaceholdertypicode.domain.model.Album
import kz.tutorial.jsonplaceholdertypicode.domain.model.Post
import kz.tutorial.jsonplaceholdertypicode.domain.repository.AlbumsRepository

class AlbumsRepositoryImpl(private val albumsApi: AlbumsApi) : AlbumsRepository {

    override suspend fun getAlbums(): List<Album> {
        return albumsApi.getAlbums()
    }

    override suspend fun getAlbum(id: Int): Album {
        return albumsApi.getAlbum(id)
    }

}