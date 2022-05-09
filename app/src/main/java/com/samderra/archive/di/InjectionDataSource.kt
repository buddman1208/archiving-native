package com.samderra.archive.data

import com.samderra.archive.data.remote.source.AuthDataSource
import org.koin.dsl.module

val remoteDataSourceModule = module {
    single { AuthDataSource(get()) }
}