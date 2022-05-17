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
import io.reactivex.rxkotlin.addTo

class MainViewModel(
    private val authDataSource: AuthDataSource,
    private val categoryDataSource: CategoryDataSource
) : BaseViewModel() {

    val displayMode: MutableLiveData<DisplayMode> = MutableLiveData(DisplayMode.GRID)
    val searchQuery: MutableLiveData<String> = MutableLiveData("")
    val sortOption: MutableLiveData<SortOption> = MutableLiveData(SortOption.NAME)

    val categoryOpenEvent: MutableLiveData<SDRCategory> = MutableLiveData()
    val event: MutableLiveData<Event<MainEvent>> = MutableLiveData()

    val categoryItems: MutableLiveData<List<SDRCategory>> = MutableLiveData(listOf())

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
        authDataSource
            .getToken(AuthTokenRequest("0"))
            .subscribe({
                println(it.toString())
                messageEvent.value = Event("${it.name}님 환영합니다.")
                PreferenceManager.userPref.token = it.token
            }, Throwable::printStackTrace)
            .addTo(compositeDisposable)


        categoryDataSource.getCategories()
            .subscribe({
                categoryItems.value = it
            }, Throwable::printStackTrace)
            .addTo(compositeDisposable)
    }

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

    fun openCategory(category: SDRCategory) {
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
    OPEN_SORT_OPTIONS
}

enum class DisplayMode {
    LIST, GRID
}