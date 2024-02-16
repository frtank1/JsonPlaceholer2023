package kz.tutorial.jsonplaceholdertypicode.di

import kz.tutorial.jsonplaceholdertypicode.domain.model.Comment
import kz.tutorial.jsonplaceholdertypicode.presentation.posts.details.comments.CommentsViewModel
import kz.tutorial.jsonplaceholdertypicode.presentation.posts.details.DetailsViewModel
import kz.tutorial.jsonplaceholdertypicode.presentation.posts.PostsViewModel
import kz.tutorial.jsonplaceholdertypicode.presentation.users.UsersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel {
        PostsViewModel(get())
    }

    viewModel {(postId: Int) ->
        DetailsViewModel(get(),get(),get(), postId)
    }

    viewModel {(postId: Int) ->
        CommentsViewModel(get(), postId)
    }

    viewModel {
        UsersViewModel(get())
    }

}