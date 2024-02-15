package kz.tutorial.jsonplaceholdertypicode.data.repository

import kz.tutorial.jsonplaceholdertypicode.data.network.MainApi
import kz.tutorial.jsonplaceholdertypicode.data.network.UsersApi
import kz.tutorial.jsonplaceholdertypicode.domain.model.User
import kz.tutorial.jsonplaceholdertypicode.domain.repository.UsersRepository

class UsersRepositoryImpl(private val userApi: UsersApi):UsersRepository {
    override suspend fun getUsers(): List<User> {
       return userApi.getUsers()
    }
}