package com.samderra.archive.di

import com.samderra.archive.data.local.pref.SDRPreference
import com.samderra.archive.data.local.pref.UserPreference
import com.samderra.archive.data.remote.source.ArticleDataSource
import com.samderra.archive.data.remote.source.AuthDataSource
import com.samderra.archive.data.remote.source.CategoryDataSource
import org.koin.dsl.module

val remoteDataSourceModule = module {
    single { AuthDataSource(get()) }
    single { CategoryDataSource(get()) }
    single { ArticleDataSource(get()) }
}

val localDataSourceModule = module {
    single<SDRPreference.UserInfo> { UserPreference(get()) }
}
