package kz.tutorial.jsonplaceholdertypicode.di

import kz.tutorial.jsonplaceholdertypicode.data.repository.AlbumsRepositoryImpl
import kz.tutorial.jsonplaceholdertypicode.data.repository.PostsRepositoryImpl
import kz.tutorial.jsonplaceholdertypicode.data.repository.UsersRepositoryImpl
import kz.tutorial.jsonplaceholdertypicode.domain.repository.AlbumsRepository
import kz.tutorial.jsonplaceholdertypicode.domain.repository.PostsRepository
import kz.tutorial.jsonplaceholdertypicode.domain.repository.UsersRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory<PostsRepository> { PostsRepositoryImpl(get()) }

    factory<UsersRepository> { UsersRepositoryImpl(get()) }

    factory<AlbumsRepository> { AlbumsRepositoryImpl(get()) }
}