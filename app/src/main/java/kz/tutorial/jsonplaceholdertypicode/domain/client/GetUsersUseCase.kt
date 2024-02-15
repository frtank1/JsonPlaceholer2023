package kz.tutorial.jsonplaceholdertypicode.domain.client

import kz.tutorial.jsonplaceholdertypicode.domain.model.User

interface GetUsersUseCase {
    suspend fun invoke():List<User>
}