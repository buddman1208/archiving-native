package com.samderra.archive.ui.view.post.fromshare

import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.samderra.archive.base.BaseViewModel
import com.samderra.archive.data.remote.source.CategoryDataSource
import com.samderra.archive.ui.adapter.CategorySelectAdapter
import com.samderra.archive.ui.model.main.SDRCategory
import com.samderra.archive.util.ext.reverse

class PostFromShareViewModel(
    private val categoryDataSource: CategoryDataSource
) : BaseViewModel() {

    private val categoryList: MutableList<SDRCategory> = mutableListOf()
    val displayedCategoryList: MutableLiveData<List<SDRCategory>> = MutableLiveData(listOf())
    val searchQuery: MutableLiveData<String> = MutableLiveData("")

    init {
        categoryDataSource.getCategories()
            .subscribeAuto {
                categoryList.clear()
                categoryList.addAll(it)
                displayedCategoryList.value = it
            }
    }

    fun clearQuery() {
        searchQuery.value = ""
    }

    fun onCategoryClicked(item: SDRCategory) = item.isChecked.reverse()

    fun search(query: String) {
        displayedCategoryList.value = if (query.isEmpty()) {
            categoryList
        } else {
            categoryList.filter { it.title.contains(query.trim()) }
        }
    }

    companion object {
        @JvmStatic
        @BindingAdapter("bindCategorySelectList")
        fun bindCategorySelectList(rv: RecyclerView, categoryList: List<SDRCategory>) {
            Log.e("asdf", categoryList.toString())
            val adapter = rv.adapter as? CategorySelectAdapter
            adapter?.updateItems(categoryList)
        }
    }
}
