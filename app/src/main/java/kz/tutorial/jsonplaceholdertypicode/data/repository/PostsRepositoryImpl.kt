package kz.tutorial.jsonplaceholdertypicode.data.repository

import kz.tutorial.jsonplaceholdertypicode.data.network.PostsApi
import kz.tutorial.jsonplaceholdertypicode.domain.model.Comment
import kz.tutorial.jsonplaceholdertypicode.domain.model.Post
import kz.tutorial.jsonplaceholdertypicode.domain.repository.PostsRepository

class PostsRepositoryImpl(private val mainApi: PostsApi) : PostsRepository {

    override suspend fun getPosts(): List<Post> {
        return mainApi.getPosts()
    }

    override suspend fun getPost(id:Int):Post{
        return mainApi.getPost(id)
    }

    override suspend fun getComments(id: Int):List<Comment>{
        return mainApi.getComments(id)
    }
}