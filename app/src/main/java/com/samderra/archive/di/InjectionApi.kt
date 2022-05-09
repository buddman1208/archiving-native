package com.samderra.archive.data

import com.samderra.archive.data.remote.api.AuthApi
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    single<AuthApi> { get<Retrofit>().create(AuthApi::class.java) }
}