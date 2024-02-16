package kz.tutorial.jsonplaceholdertypicode.di

import kz.tutorial.jsonplaceholdertypicode.data.network.PostsApi
import kz.tutorial.jsonplaceholdertypicode.data.network.UsersApi
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


val networkModule = module {

    factory<HttpLoggingInterceptor> {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS)
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        interceptor
    }

    factory<OkHttpClient> {
        val httpLoggingInterceptor: HttpLoggingInterceptor = get()
        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor)
            .build()

        okHttpClient
    }

    factory {
        GsonConverterFactory.create()
    }

    factory<Retrofit> {
        val okHttpClient: OkHttpClient = get()
        val gsonConverterFactory: GsonConverterFactory = get()
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    factory<PostsApi> {
        val retrofit: Retrofit = get()

        retrofit.create(PostsApi::class.java)
    }

    factory<UsersApi> {
        val retrofit: Retrofit = get()

        retrofit.create(UsersApi::class.java)
    }
}