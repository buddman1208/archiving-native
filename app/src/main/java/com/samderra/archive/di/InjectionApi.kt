package com.samderra.archive.di

import com.samderra.archive.data.remote.api.AuthApi
import com.samderra.archive.data.remote.api.CategoryApi
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    single<AuthApi> { get<Retrofit>().create(AuthApi::class.java) }
    single<CategoryApi> { get<Retrofit>().create(CategoryApi::class.java) }
}