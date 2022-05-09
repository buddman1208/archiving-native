package com.samderra.archive.ui.view.category

import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.samderra.archive.base.BaseViewModel
import com.samderra.archive.ui.adapter.ArticleGridAdapter
import com.samderra.archive.ui.model.article.SDRArticle
import com.samderra.archive.ui.view.main.SortOption
import com.samderra.archive.util.Event

class CategoryViewModel : BaseViewModel() {

    val articleOpenEvent = MutableLiveData<SDRArticle>()
    val categoryActions = MutableLiveData<Event<CategoryActions>>()
    val sortOption: MutableLiveData<SortOption> = MutableLiveData(SortOption.NAME)

    val title: MutableLiveData<String> = MutableLiveData("")

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

    fun showSortOptions() {
        categoryActions.value = Event(CategoryActions.OPEN_SORT_OPTIONS)
    }

    fun changeSortOptions(option: SortOption) {
        sortOption.value = option
    }

    fun openArticle(article: SDRArticle) {
        articleOpenEvent.value = article
    }

    companion object {
        @JvmStatic
        @BindingAdapter("bindArticleGridList")
        fun bindArticleGridList(rv: RecyclerView, articleList: List<SDRArticle>) {
            val adapter = rv.adapter as? ArticleGridAdapter?
            adapter?.updateItems(articleList)
        }
    }
}

enum class CategoryActions {
    OPEN_SORT_OPTIONS
}