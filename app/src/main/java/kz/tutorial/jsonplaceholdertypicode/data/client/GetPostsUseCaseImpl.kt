package kz.tutorial.jsonplaceholdertypicode.data.client

import kz.tutorial.jsonplaceholdertypicode.domain.client.GetPostsUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.model.Post
import kz.tutorial.jsonplaceholdertypicode.domain.repository.PostsRepository

class GetPostsUseCaseImpl(private val postsRepository: PostsRepository) : GetPostsUseCase {
    override suspend fun invoke(): List<Post> {
        return postsRepository.getPosts()
    }
}