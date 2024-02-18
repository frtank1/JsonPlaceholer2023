package kz.tutorial.jsonplaceholdertypicode.domain.model

import kz.tutorial.jsonplaceholdertypicode.presentation.utils.DEFAULT_STRING

data class AlbumsObject(
    val album: Album,
    val userName:String,
    val urlFirstPhoto:String
)

fun albumConvertToAlbusObject(users:List<User>,photos:List<Photo>,albums:List<Album>):List<AlbumsObject>{
    return  albums.map {album ->
        AlbumsObject(
            album = album,
            userName = users.filter { album.userId == it.id }.firstOrNull()?.username?: DEFAULT_STRING,
            urlFirstPhoto = photos.filter { album.id == it.albumId } .firstOrNull() ?.url
                ?: DEFAULT_STRING
        )
    }
}


