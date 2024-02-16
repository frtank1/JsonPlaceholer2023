package kz.tutorial.jsonplaceholdertypicode.data.client

import kz.tutorial.jsonplaceholdertypicode.domain.client.GetUsersUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.model.User
import kz.tutorial.jsonplaceholdertypicode.domain.repository.UsersRepository

class GetUsersUseCaseImpl(private val usersRepository: UsersRepository) : GetUsersUseCase {
    override suspend fun invoke(): List<User> {
        return usersRepository.getUsers()
    }

    override suspend fun getUser(id: Int): User {
       return usersRepository.getUser(id)
    }

}