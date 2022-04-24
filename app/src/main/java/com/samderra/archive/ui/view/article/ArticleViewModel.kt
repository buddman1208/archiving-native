package com.samderra.archive.ui.view.article

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.samderra.archive.base.BaseViewModel
import com.samderra.archive.ui.adapter.ArticleListAdapter
import com.samderra.archive.ui.model.article.Article

class ArticleViewModel : BaseViewModel() {

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
        @BindingAdapter("bindArticleList")
        fun bindArticleList(rv: RecyclerView, articleList: List<Article>) {
            val adapter = rv.adapter as? ArticleListAdapter?
            adapter?.updateItems(articleList)
        }
    }
}