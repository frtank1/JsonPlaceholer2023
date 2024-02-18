package kz.tutorial.jsonplaceholdertypicode.di

import kz.tutorial.jsonplaceholdertypicode.data.client.GetAlbumsUseCaseImpl
import kz.tutorial.jsonplaceholdertypicode.data.client.GetCommentsUseCaseImpl
import kz.tutorial.jsonplaceholdertypicode.data.client.GetPhotosUseCaseImpl
import kz.tutorial.jsonplaceholdertypicode.data.client.GetPostUseCaseImpl
import kz.tutorial.jsonplaceholdertypicode.data.client.GetPostsUseCaseImpl
import kz.tutorial.jsonplaceholdertypicode.data.client.GetUserUseCaseImpl
import kz.tutorial.jsonplaceholdertypicode.data.client.GetUsersUseCaseImpl
import kz.tutorial.jsonplaceholdertypicode.domain.client.GetAlbumsUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.client.GetCommentsUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.client.GetPhotosUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.client.GetPostUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.client.GetPostsUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.client.GetUserUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.client.GetUsersUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory<GetPostsUseCase> { GetPostsUseCaseImpl(get()) }

    factory<GetPostUseCase> { GetPostUseCaseImpl(get()) }

    factory<GetUsersUseCase> { GetUsersUseCaseImpl(get()) }

    factory<GetCommentsUseCase> { GetCommentsUseCaseImpl(get()) }

    factory<GetAlbumsUseCase> { GetAlbumsUseCaseImpl(get()) }

    factory<GetPhotosUseCase> { GetPhotosUseCaseImpl(get()) }

    factory<GetUserUseCase> { GetUserUseCaseImpl(get()) }
}