package kz.tutorial.jsonplaceholdertypicode.data.client

import kz.tutorial.jsonplaceholdertypicode.domain.client.GetPostUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.client.GetPostsUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.model.Comment
import kz.tutorial.jsonplaceholdertypicode.domain.model.Post
import kz.tutorial.jsonplaceholdertypicode.domain.repository.PostsRepository

class GetPostUseCaseImpl (private val postRepository: PostsRepository) : GetPostUseCase {
    override suspend fun invoke(id:Int): Post {
        return postRepository.getPost(id)
    }

    override suspend fun getComments(id: Int): List<Comment> {
      return postRepository.getComments(id)
    }
}