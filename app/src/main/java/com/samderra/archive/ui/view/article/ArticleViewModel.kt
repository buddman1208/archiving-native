package com.samderra.archive.ui.view.article

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.samderra.archive.base.BaseViewModel
import com.samderra.archive.ui.adapter.ArticleListAdapter
import com.samderra.archive.ui.model.article.SDRArticle

class ArticleViewModel : BaseViewModel() {

    val articleItems = listOf(
        SDRArticle.dummy(),
        SDRArticle.dummy(),
        SDRArticle.dummy(),
        SDRArticle.dummy(),
        SDRArticle.dummy(),
        SDRArticle.dummy(),
        SDRArticle.dummy(),
        SDRArticle.dummy(),
        SDRArticle.dummy(),
        SDRArticle.dummy(),
        SDRArticle.dummy(),
        SDRArticle.dummy(),
        SDRArticle.dummy(),
        SDRArticle.dummy()
    )

    companion object {
        @JvmStatic
        @BindingAdapter("bindArticleList")
        fun bindArticleList(rv: RecyclerView, articleList: List<SDRArticle>) {
            val adapter = rv.adapter as? ArticleListAdapter?
            adapter?.updateItems(articleList)
        }
    }
}