package com.samderra.archive.ui.view.main

import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.samderra.archive.base.BaseViewModel
import com.samderra.archive.data.local.pref.PreferenceManager
import com.samderra.archive.data.remote.model.request.AuthTokenRequest
import com.samderra.archive.data.remote.source.AuthDataSource
import com.samderra.archive.data.remote.source.CategoryDataSource
import com.samderra.archive.ui.adapter.CategoryAdapter
import com.samderra.archive.ui.adapter.CategorySearchAdapter
import com.samderra.archive.ui.model.main.SDRCategory
import com.samderra.archive.util.Event
import com.samderra.archive.util.emit
import com.samderra.archive.util.ext.reverse

class MainViewModel(
    private val authDataSource: AuthDataSource,
    private val categoryDataSource: CategoryDataSource
) : BaseViewModel() {

    val displayMode: MutableLiveData<DisplayMode> = MutableLiveData(DisplayMode.GRID)
    val isDeleteMode: MutableLiveData<Boolean> = MutableLiveData(false)
    val searchQuery: MutableLiveData<String> = MutableLiveData("")
    val sortOption: MutableLiveData<SortOption> = MutableLiveData(SortOption.NAME)

    val categoryOpenEvent: MutableLiveData<SDRCategory> = MutableLiveData()
    val event: MutableLiveData<Event<MainEvent>> = MutableLiveData()

    val categoryItems: MutableLiveData<List<SDRCategory>> = MutableLiveData(listOf())
    val checkedCategoryItemCnt: MutableLiveData<Int> = MutableLiveData(0)

    val categorySearchResult = MutableLiveData<List<SDRCategory>>(
        listOf(
            SDRCategory.dummy(),
            SDRCategory.dummy(),
            SDRCategory.dummy(),
            SDRCategory.dummy(),
            SDRCategory.dummy(),
            SDRCategory.dummy(),
            SDRCategory.dummy(),
            SDRCategory.dummy(),
            SDRCategory.dummy(),
            SDRCategory.dummy(),
            SDRCategory.dummy(),
            SDRCategory.dummy(),
            SDRCategory.dummy(),
            SDRCategory.dummy(),
            SDRCategory.dummy(),
            SDRCategory.dummy()
        )
    )

    init {
        PreferenceManager.userPref.token = ""
        authDataSource
            .getToken(AuthTokenRequest("0"))
            .doOnNext {
                println(it.toString())
                messageEvent.value = Event("${it.name}님 환영합니다.")
                PreferenceManager.userPref.token = it.token
            }
            .flatMap { categoryDataSource.getCategories() }
            .subscribeAuto {
                categoryItems.value = it
            }
    }

    fun clearSearchQuery() {
        searchQuery.value = ""
    }

    fun changeSortOptions(option: SortOption) {
        sortOption.value = option
    }

    fun switchDisplayMode() {
        displayMode.value = when (displayMode.value) {
            DisplayMode.LIST -> DisplayMode.GRID
            DisplayMode.GRID -> DisplayMode.LIST
            else -> return
        }
    }

    fun showMainOptions() {
        event.emit(MainEvent.SHOW_MAIN_OPTIONS)
    }

    fun clearClickedItems() {
        categoryItems.value?.forEach { it.isChecked.set(false) }
        checkedCategoryItemCnt.value = 0
    }

    fun onCategoryClicked(category: SDRCategory) {
        if (isDeleteMode.value == true) {
            category.isChecked.reverse()
            checkedCategoryItemCnt.value =
                categoryItems.value?.filter { it.isChecked.get() }?.count()
        } else {
            categoryOpenEvent.value = category
        }
    }

    fun onCategoryDeleteAction(isConfirm: Boolean) {
        event.emit(MainEvent.CATEGORY_DELETE_CONFIRM)
        if (isConfirm) {
            // todo
        }
    }

    fun forceDisplayMode(_displayMode: DisplayMode) {
        displayMode.value = _displayMode
    }

    companion object {
        @JvmStatic
        @BindingAdapter("bindCategoryList")
        fun bindCategoryList(rv: RecyclerView, categoryList: List<SDRCategory>) {
            val adapter = rv.adapter as? CategoryAdapter?
            adapter?.updateItems(categoryList)
        }

        @JvmStatic
        @BindingAdapter("bindCategorySearchList")
        fun bindCategorySearchList(rv: RecyclerView, categoryList: List<SDRCategory>) {
            val adapter = rv.adapter as? CategorySearchAdapter?
            adapter?.updateItems(categoryList)
        }
    }
}

enum class MainEvent {
    SHOW_POST_ACTIVITY,
    SHOW_MAIN_OPTIONS,
    CATEGORY_DELETE_CONFIRM
}

enum class DisplayMode {
    LIST, GRID
}