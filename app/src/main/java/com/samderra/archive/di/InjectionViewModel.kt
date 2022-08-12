package com.samderra.archive.di

import com.samderra.archive.ui.view.article.ArticleViewModel
import com.samderra.archive.ui.view.category.CategoryViewModel
import com.samderra.archive.ui.view.main.MainViewModel
import com.samderra.archive.ui.view.post.fromshare.PostFromShareViewModel
import com.samderra.archive.ui.view.splash.SplashViewModel
import com.samderra.archive.ui.view.tutorial.TutorialViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get(), get()) }
    viewModel { CategoryViewModel(get()) }
    viewModel { ArticleViewModel(get()) }
    viewModel { TutorialViewModel() }
    viewModel { PostFromShareViewModel(get()) }
    viewModel { SplashViewModel(get()) }
}
