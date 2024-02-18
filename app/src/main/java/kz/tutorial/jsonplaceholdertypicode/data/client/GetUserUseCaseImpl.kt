package kz.tutorial.jsonplaceholdertypicode.data.client

import kz.tutorial.jsonplaceholdertypicode.domain.client.GetUserUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.client.GetUsersUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.model.User
import kz.tutorial.jsonplaceholdertypicode.domain.repository.UsersRepository

class GetUserUseCaseImpl(private val userRepository: UsersRepository) : GetUserUseCase {
    override suspend fun getUser(id:Int): User {
        return userRepository.getUser(id)
    }

}