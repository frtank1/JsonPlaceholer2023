package kz.tutorial.jsonplaceholdertypicode.di

import kz.tutorial.jsonplaceholdertypicode.domain.model.Album
import kz.tutorial.jsonplaceholdertypicode.domain.model.Comment
import kz.tutorial.jsonplaceholdertypicode.presentation.albums.AlbumsViewModel
import kz.tutorial.jsonplaceholdertypicode.presentation.albums.photo_user.PhotoViewModel
import kz.tutorial.jsonplaceholdertypicode.presentation.posts.details.comments.CommentsViewModel
import kz.tutorial.jsonplaceholdertypicode.presentation.posts.details.DetailsViewModel
import kz.tutorial.jsonplaceholdertypicode.presentation.posts.PostsViewModel
import kz.tutorial.jsonplaceholdertypicode.presentation.todos.ToDosViewModel
import kz.tutorial.jsonplaceholdertypicode.presentation.users.UsersViewModel
import kz.tutorial.jsonplaceholdertypicode.presentation.users.user.UserViewModel
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

    viewModel{(userId: Int)->
        UserViewModel(get(),userId)
    }

    viewModel{(userId: Int)->
        ToDosViewModel(get(),userId)
    }

    viewModel {
        AlbumsViewModel(get(),get(),get())
    }
    viewModel {(albumId: Int)->
        PhotoViewModel(get(), albumId)
    }


}