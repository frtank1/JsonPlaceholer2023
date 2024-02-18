package kz.tutorial.jsonplaceholdertypicode.domain.client

import kz.tutorial.jsonplaceholdertypicode.domain.model.User

interface GetUserUseCase {
    suspend fun getUser(id:Int): User

}