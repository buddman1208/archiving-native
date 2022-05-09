package com.samderra.archive.ui.view.main

import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.samderra.archive.base.BaseViewModel
import com.samderra.archive.ui.adapter.CategoryAdapter
import com.samderra.archive.ui.adapter.CategorySearchAdapter
import com.samderra.archive.ui.model.main.Category
import com.samderra.archive.util.Event
import com.samderra.archive.util.emit

class MainViewModel : BaseViewModel() {

    val displayMode: MutableLiveData<DisplayMode> = MutableLiveData(DisplayMode.GRID)
    val searchQuery: MutableLiveData<String> = MutableLiveData("")
    val sortOption: MutableLiveData<SortOption> = MutableLiveData(SortOption.NAME)

    val categoryOpenEvent: MutableLiveData<Category> = MutableLiveData()
    val event: MutableLiveData<Event<MainEvent>> = MutableLiveData()

    val categoryItems = listOf(

        Category.dummy(),
        Category.dummy(),
        Category.dummy(),
        Category.dummy(),
        Category.dummy(),
        Category.dummy(),
        Category.dummy(),
        Category.dummy(),
        Category.dummy(),
        Category.dummy(),
        Category.dummy(),
        Category.dummy(),
        Category.dummy(),
        Category.dummy()
    )

    val categorySearchResult = MutableLiveData<List<Category>>(
        listOf(
            Category.dummy(),
            Category.dummy(),
            Category.dummy(),
            Category.dummy(),
            Category.dummy(),
            Category.dummy(),
            Category.dummy(),
            Category.dummy(),
            Category.dummy(),
            Category.dummy(),
            Category.dummy(),
            Category.dummy(),
            Category.dummy(),
            Category.dummy(),
            Category.dummy(),
            Category.dummy()
        )
    )

    fun clearSearchQuery() {
        searchQuery.value = ""
    }

    fun showSortOptions() {
        event.emit(MainEvent.OPEN_SORT_OPTIONS)
    }

    fun changeSortOptions(option: SortOption) {
        sortOption.value = option
    }

    fun createCategory() {
        // todo
    }

    fun openCategory(category: Category) {
        categoryOpenEvent.value = category
    }

    fun switchDisplayMode() {
        displayMode.value = when (displayMode.value) {
            DisplayMode.LIST -> DisplayMode.GRID
            DisplayMode.GRID -> DisplayMode.LIST
            else -> return
        }
    }

    fun forceDisplayMode(_displayMode: DisplayMode) {
        displayMode.value = _displayMode
    }

    companion object {
        @JvmStatic
        @BindingAdapter("bindCategoryList")
        fun bindCategoryList(rv: RecyclerView, categoryList: List<Category>) {
            val adapter = rv.adapter as? CategoryAdapter?
            adapter?.updateItems(categoryList)
        }

        @JvmStatic
        @BindingAdapter("bindCategorySearchList")
        fun bindCategorySearchList(rv: RecyclerView, categoryList: List<Category>) {
            val adapter = rv.adapter as? CategorySearchAdapter?
            adapter?.updateItems(categoryList)
        }
    }
}

enum class MainEvent {
    OPEN_SORT_OPTIONS
}

enum class DisplayMode {
    LIST, GRID
}