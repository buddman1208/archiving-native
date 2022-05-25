package com.samderra.archive.ui.view.category

import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.samderra.archive.base.BaseViewModel
import com.samderra.archive.data.remote.source.ArticleDataSource
import com.samderra.archive.ui.adapter.ArticleGridAdapter
import com.samderra.archive.ui.model.article.SDRArticle
import com.samderra.archive.ui.model.main.SDRCategory
import com.samderra.archive.ui.view.main.SortOption
import com.samderra.archive.util.Event

class CategoryViewModel(
    private val articleDataSource: ArticleDataSource
) : BaseViewModel() {

    val articleOpenEvent = MutableLiveData<SDRArticle>()
    val categoryActions = MutableLiveData<Event<CategoryActions>>()
    val sortOption: MutableLiveData<SortOption> = MutableLiveData(SortOption.NAME)

    val category: MutableLiveData<SDRCategory> = MutableLiveData()

    val articleItems: MutableLiveData<List<SDRArticle>> = MutableLiveData(listOf())

    fun initData() {
        articleDataSource
            .getArticlesByCategory(category.value?.id ?: 0.toLong())
            .subscribeAuto {
                articleItems.value = it
            }
    }

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