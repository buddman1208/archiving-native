package com.samderra.archive.ui.view.category

import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.samderra.archive.base.BaseViewModel
import com.samderra.archive.data.remote.source.ArticleDataSource
import com.samderra.archive.ui.adapter.ArticleGridAdapter
import com.samderra.archive.ui.model.article.SDRArticle
import com.samderra.archive.ui.model.main.SDRCategory
import com.samderra.archive.ui.view.main.SortOption
import com.samderra.archive.util.Event
import com.samderra.archive.util.emit
import com.samderra.archive.util.ext.reverse

class CategoryViewModel(
    private val articleDataSource: ArticleDataSource
) : BaseViewModel() {

    val articleOpenEvent = MutableLiveData<SDRArticle>()
    val event = MutableLiveData<Event<CategoryActions>>()
    val sortOption: MutableLiveData<SortOption> = MutableLiveData(SortOption.NAME)
    val isDeleteMode: ObservableBoolean = ObservableBoolean(false)
    val category: MutableLiveData<SDRCategory> = MutableLiveData()

    val articleItems: MutableLiveData<List<SDRArticle>> = MutableLiveData(listOf())
    val checkedArticleItemCnt: MutableLiveData<Int> = MutableLiveData(0)


    fun initData() {
        articleDataSource
            .getArticlesByCategory(category.value?.id ?: 0.toLong())
            .subscribeAuto {
                articleItems.value = it
            }
    }

    fun showSortOptions() {
        event.value = Event(CategoryActions.OPEN_SORT_OPTIONS)
    }

    fun changeSortOptions(option: SortOption) {
        sortOption.value = option
    }

    fun clearClickedItems() {
        articleItems.value?.forEach { it.isChecked.set(false) }
        checkedArticleItemCnt.value = 0
    }


    fun onArticleClicked(article: SDRArticle) {
        if (isDeleteMode.get()) {
            article.isChecked.reverse()
            checkedArticleItemCnt.value =
                articleItems.value?.filter { it.isChecked.get() }?.count()
        } else {
            articleOpenEvent.value = article
        }
    }

    fun onCategoryDeleteAction(isConfirm: Boolean) {
        event.emit(CategoryActions.ARTICLE_DELETE_CONFIRM)
        if (isConfirm) {
            // todo
        }
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
    OPEN_SORT_OPTIONS,
    ARTICLE_DELETE_CONFIRM
}