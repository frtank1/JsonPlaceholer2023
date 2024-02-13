package kz.tutorial.jsonplaceholdertypicode.di

import kz.tutorial.jsonplaceholdertypicode.data.client.GetPostUseCaseImpl
import kz.tutorial.jsonplaceholdertypicode.data.client.GetPostsUseCaseImpl
import kz.tutorial.jsonplaceholdertypicode.domain.client.GetPostUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.client.GetPostsUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory<GetPostsUseCase> { GetPostsUseCaseImpl(get()) }

    factory<GetPostUseCase>{GetPostUseCaseImpl(get())}
}