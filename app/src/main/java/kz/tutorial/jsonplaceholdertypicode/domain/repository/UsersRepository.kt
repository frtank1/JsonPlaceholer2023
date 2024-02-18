package kz.tutorial.jsonplaceholdertypicode.domain.repository

import kz.tutorial.jsonplaceholdertypicode.domain.model.User

interface UsersRepository {
    suspend fun getUsers():List<User>
    suspend fun getUser(id:Int):User
}