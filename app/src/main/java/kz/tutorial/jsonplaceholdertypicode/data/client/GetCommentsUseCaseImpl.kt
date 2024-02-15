package kz.tutorial.jsonplaceholdertypicode.data.client

import kz.tutorial.jsonplaceholdertypicode.domain.client.GetCommentsUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.model.Comment
import kz.tutorial.jsonplaceholdertypicode.domain.repository.PostsRepository

class GetCommentsUseCaseImpl(private val postsRepository: PostsRepository): GetCommentsUseCase {
    override suspend fun getComments(id: Int): List<Comment> {
      return postsRepository.getComments(id)
    }
}