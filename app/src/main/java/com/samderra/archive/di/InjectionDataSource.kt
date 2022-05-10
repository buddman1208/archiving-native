package com.samderra.archive.di

import com.samderra.archive.data.remote.source.AuthDataSource
import com.samderra.archive.data.remote.source.CategoryDataSource
import org.koin.dsl.module

val remoteDataSourceModule = module {
    single { AuthDataSource(get()) }
    single { CategoryDataSource(get()) }
}