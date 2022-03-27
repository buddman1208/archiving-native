package com.samderra.archive.ui.view.category

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.samderra.archive.base.BaseViewModel
import com.samderra.archive.ui.adapter.ArticleGridAdapter
import com.samderra.archive.ui.model.article.Article

class CategoryViewModel : BaseViewModel() {

    val articleItems = listOf(
        Article.dummy(),
        Article.dummy(),
        Article.dummy(),
        Article.dummy(),
        Article.dummy(),
        Article.dummy(),
        Article.dummy(),
        Article.dummy(),
        Article.dummy(),
        Article.dummy(),
        Article.dummy(),
        Article.dummy(),
        Article.dummy(),
        Article.dummy()
    )

    companion object {
        @JvmStatic
        @BindingAdapter("bindArticleGridList")
        fun bindArticleGridList(rv: RecyclerView, articleList: List<Article>) {
            val adapter = rv.adapter as? ArticleGridAdapter?
            adapter?.updateItems(articleList)
        }
    }
}