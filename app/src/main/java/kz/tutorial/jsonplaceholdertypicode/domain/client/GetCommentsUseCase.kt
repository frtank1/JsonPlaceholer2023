package kz.tutorial.jsonplaceholdertypicode.domain.client

import kz.tutorial.jsonplaceholdertypicode.domain.model.Comment

interface GetCommentsUseCase {
    suspend fun getComments(id:Int): List<Comment>
}