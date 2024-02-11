package kz.tutorial.jsonplaceholdertypicode.di

import kz.tutorial.jsonplaceholdertypicode.data.client.GetPostsUseCaseImpl
import kz.tutorial.jsonplaceholdertypicode.domain.client.GetPostsUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory<GetPostsUseCase> { GetPostsUseCaseImpl(get()) }
}