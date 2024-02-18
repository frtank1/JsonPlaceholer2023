package kz.tutorial.jsonplaceholdertypicode.data.network

import kz.tutorial.jsonplaceholdertypicode.domain.model.Photo
import retrofit2.http.GET
import retrofit2.http.Path

interface PhotosApi {
    @GET("photos")
    suspend fun getPhotos():List<Photo>

    @GET("photos/{id}")
    suspend fun getPhoto(@Path("id") id:Int):Photo
}