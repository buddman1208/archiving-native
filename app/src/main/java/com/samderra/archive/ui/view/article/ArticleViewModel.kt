package com.samderra.archive.ui.view.article

import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.samderra.archive.base.BaseViewModel
import com.samderra.archive.data.remote.source.ArticleDataSource
import com.samderra.archive.ui.adapter.ArticleListAdapter
import com.samderra.archive.ui.model.article.SDRArticle

class ArticleViewModel(
    private val articleDataSource: ArticleDataSource
) : BaseViewModel() {

    var categoryId: Long = 0
    val articleItems: MutableLiveData<List<SDRArticle>> = MutableLiveData(listOf())

    fun initData() {
        articleDataSource.getArticlesByCategory(categoryId)
            .subscribeAuto {
                articleItems.value = it
            }
    }

    companion object {
        @JvmStatic
        @BindingAdapter("bindArticleList")
        fun bindArticleList(rv: RecyclerView, articleList: List<SDRArticle>) {
            val adapter = rv.adapter as? ArticleListAdapter?
            adapter?.updateItems(articleList)
        }
    }
}