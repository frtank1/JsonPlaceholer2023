package kz.tutorial.jsonplaceholdertypicode.di

import kz.tutorial.jsonplaceholdertypicode.presentation.details.DetailsViewModel
import kz.tutorial.jsonplaceholdertypicode.presentation.posts.PostsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel {
        PostsViewModel(get())
    }

    viewModel {(postId: Int) ->
        DetailsViewModel(get(), postId)
    }

}