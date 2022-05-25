package com.samderra.archive.ui.view.article

import android.os.Bundle
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.samderra.archive.base.BaseViewModel
import com.samderra.archive.data.remote.source.ArticleDataSource
import com.samderra.archive.ui.adapter.ArticleListAdapter
import com.samderra.archive.ui.model.article.SDRArticle
import com.samderra.archive.util.Event
import com.samderra.archive.util.emit

class ArticleViewModel(
    private val articleDataSource: ArticleDataSource
) : BaseViewModel() {

    var categoryId: Long = 0
    val articleItems: MutableLiveData<List<SDRArticle>> = MutableLiveData(listOf())
    val actions: MutableLiveData<Event<Bundle>> = MutableLiveData()

    val articleToDelete: MutableLiveData<Event<SDRArticle>> = MutableLiveData()

    fun initData() {
        articleDataSource.getArticlesByCategory(categoryId)
            .subscribeAuto {
                articleItems.value = it
            }
    }

    fun requestDeleteArticle(article: SDRArticle) {
        articleToDelete.emit(article)
    }

    fun deleteArticle(article: SDRArticle) {
        articleDataSource.deleteArticles(listOf(article.articleId))
            .subscribeAuto {
                messageEvent.emit("게시글이 삭제되었습니다.")
                initData()
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

enum class ArticleEvent {
    ASK_FOR_DELETE
}