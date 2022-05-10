package com.samderra.archive.di

import com.samderra.archive.ui.view.article.ArticleViewModel
import com.samderra.archive.ui.view.category.CategoryViewModel
import com.samderra.archive.ui.view.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get(), get()) }
    viewModel { CategoryViewModel() }
    viewModel { ArticleViewModel() }
}
