package kz.tutorial.jsonplaceholdertypicode.domain.repository

import kz.tutorial.jsonplaceholdertypicode.domain.model.Album
import kz.tutorial.jsonplaceholdertypicode.domain.model.Post

interface AlbumsRepository {

    suspend fun getAlbums(): List<Album>

    suspend fun getAlbum(id:Int): Album
}