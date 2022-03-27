package com.samderra.archive.ui.view.main

import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.samderra.archive.base.BaseViewModel
import com.samderra.archive.ui.adapter.CategoryAdapter
import com.samderra.archive.ui.adapter.CategorySearchAdapter
import com.samderra.archive.ui.model.main.Category

class MainViewModel : BaseViewModel() {

    val displayMode: MutableLiveData<DisplayMode> = MutableLiveData(DisplayMode.GRID)
    val searchQuery: MutableLiveData<String> = MutableLiveData("")

    val categoryItems = listOf(
        Category(
            "인테리어",
            63,
            "https://w.namu.la/s/69493e71674f490fc8565157f87fc5d03ec665597e2997e62c7bf9b9127da40aedd0cec3a527fcdd0f584e00bc4817e27583ed02a06a93d6dffe3a3beaf2adee6aefe9294bfba8df605158bfe89fa978d99fabd6da717f82028c0cc4739cc57f"
        ),
        Category(
            "인테리어",
            63,
            "https://w.namu.la/s/69493e71674f490fc8565157f87fc5d03ec665597e2997e62c7bf9b9127da40aedd0cec3a527fcdd0f584e00bc4817e27583ed02a06a93d6dffe3a3beaf2adee6aefe9294bfba8df605158bfe89fa978d99fabd6da717f82028c0cc4739cc57f"
        ),
        Category(
            "인테리어",
            63,
            "https://w.namu.la/s/69493e71674f490fc8565157f87fc5d03ec665597e2997e62c7bf9b9127da40aedd0cec3a527fcdd0f584e00bc4817e27583ed02a06a93d6dffe3a3beaf2adee6aefe9294bfba8df605158bfe89fa978d99fabd6da717f82028c0cc4739cc57f"
        ),
        Category(
            "인테리어",
            63,
            "https://w.namu.la/s/69493e71674f490fc8565157f87fc5d03ec665597e2997e62c7bf9b9127da40aedd0cec3a527fcdd0f584e00bc4817e27583ed02a06a93d6dffe3a3beaf2adee6aefe9294bfba8df605158bfe89fa978d99fabd6da717f82028c0cc4739cc57f"
        ),
        Category(
            "인테리어",
            63,
            "https://w.namu.la/s/69493e71674f490fc8565157f87fc5d03ec665597e2997e62c7bf9b9127da40aedd0cec3a527fcdd0f584e00bc4817e27583ed02a06a93d6dffe3a3beaf2adee6aefe9294bfba8df605158bfe89fa978d99fabd6da717f82028c0cc4739cc57f"
        ),
        Category(
            "인테리어",
            63,
            "https://w.namu.la/s/69493e71674f490fc8565157f87fc5d03ec665597e2997e62c7bf9b9127da40aedd0cec3a527fcdd0f584e00bc4817e27583ed02a06a93d6dffe3a3beaf2adee6aefe9294bfba8df605158bfe89fa978d99fabd6da717f82028c0cc4739cc57f"
        ),
        Category(
            "인테리어",
            63,
            "https://w.namu.la/s/69493e71674f490fc8565157f87fc5d03ec665597e2997e62c7bf9b9127da40aedd0cec3a527fcdd0f584e00bc4817e27583ed02a06a93d6dffe3a3beaf2adee6aefe9294bfba8df605158bfe89fa978d99fabd6da717f82028c0cc4739cc57f"
        ),
        Category(
            "인테리어",
            63,
            "https://w.namu.la/s/69493e71674f490fc8565157f87fc5d03ec665597e2997e62c7bf9b9127da40aedd0cec3a527fcdd0f584e00bc4817e27583ed02a06a93d6dffe3a3beaf2adee6aefe9294bfba8df605158bfe89fa978d99fabd6da717f82028c0cc4739cc57f"
        ),
        Category(
            "인테리어",
            63,
            "https://w.namu.la/s/69493e71674f490fc8565157f87fc5d03ec665597e2997e62c7bf9b9127da40aedd0cec3a527fcdd0f584e00bc4817e27583ed02a06a93d6dffe3a3beaf2adee6aefe9294bfba8df605158bfe89fa978d99fabd6da717f82028c0cc4739cc57f"
        ),
        Category(
            "인테리어",
            63,
            "https://w.namu.la/s/69493e71674f490fc8565157f87fc5d03ec665597e2997e62c7bf9b9127da40aedd0cec3a527fcdd0f584e00bc4817e27583ed02a06a93d6dffe3a3beaf2adee6aefe9294bfba8df605158bfe89fa978d99fabd6da717f82028c0cc4739cc57f"
        ),
        Category(
            "인테리어",
            63,
            "https://w.namu.la/s/69493e71674f490fc8565157f87fc5d03ec665597e2997e62c7bf9b9127da40aedd0cec3a527fcdd0f584e00bc4817e27583ed02a06a93d6dffe3a3beaf2adee6aefe9294bfba8df605158bfe89fa978d99fabd6da717f82028c0cc4739cc57f"
        ),
        Category(
            "인테리어",
            63,
            "https://w.namu.la/s/69493e71674f490fc8565157f87fc5d03ec665597e2997e62c7bf9b9127da40aedd0cec3a527fcdd0f584e00bc4817e27583ed02a06a93d6dffe3a3beaf2adee6aefe9294bfba8df605158bfe89fa978d99fabd6da717f82028c0cc4739cc57f"
        ),
        Category(
            "인테리어",
            63,
            "https://w.namu.la/s/69493e71674f490fc8565157f87fc5d03ec665597e2997e62c7bf9b9127da40aedd0cec3a527fcdd0f584e00bc4817e27583ed02a06a93d6dffe3a3beaf2adee6aefe9294bfba8df605158bfe89fa978d99fabd6da717f82028c0cc4739cc57f"
        ),
        Category(
            "인테리어",
            63,
            "https://w.namu.la/s/69493e71674f490fc8565157f87fc5d03ec665597e2997e62c7bf9b9127da40aedd0cec3a527fcdd0f584e00bc4817e27583ed02a06a93d6dffe3a3beaf2adee6aefe9294bfba8df605158bfe89fa978d99fabd6da717f82028c0cc4739cc57f"
        ),
        Category(
            "인테리어",
            63,
            "https://w.namu.la/s/69493e71674f490fc8565157f87fc5d03ec665597e2997e62c7bf9b9127da40aedd0cec3a527fcdd0f584e00bc4817e27583ed02a06a93d6dffe3a3beaf2adee6aefe9294bfba8df605158bfe89fa978d99fabd6da717f82028c0cc4739cc57f"
        ),
        Category(
            "인테리어",
            63,
            "https://w.namu.la/s/69493e71674f490fc8565157f87fc5d03ec665597e2997e62c7bf9b9127da40aedd0cec3a527fcdd0f584e00bc4817e27583ed02a06a93d6dffe3a3beaf2adee6aefe9294bfba8df605158bfe89fa978d99fabd6da717f82028c0cc4739cc57f"
        )
    )

    val categorySearchResult = MutableLiveData<List<Category>>(
        listOf(
            Category(
                "interior",
                63,
                "https://w.namu.la/s/69493e71674f490fc8565157f87fc5d03ec665597e2997e62c7bf9b9127da40aedd0cec3a527fcdd0f584e00bc4817e27583ed02a06a93d6dffe3a3beaf2adee6aefe9294bfba8df605158bfe89fa978d99fabd6da717f82028c0cc4739cc57f"
            ),
            Category(
                "interior",
                63,
                "https://w.namu.la/s/69493e71674f490fc8565157f87fc5d03ec665597e2997e62c7bf9b9127da40aedd0cec3a527fcdd0f584e00bc4817e27583ed02a06a93d6dffe3a3beaf2adee6aefe9294bfba8df605158bfe89fa978d99fabd6da717f82028c0cc4739cc57f"
            ),
            Category(
                "interior",
                63,
                "https://w.namu.la/s/69493e71674f490fc8565157f87fc5d03ec665597e2997e62c7bf9b9127da40aedd0cec3a527fcdd0f584e00bc4817e27583ed02a06a93d6dffe3a3beaf2adee6aefe9294bfba8df605158bfe89fa978d99fabd6da717f82028c0cc4739cc57f"
            ),
            Category(
                "interior",
                63,
                "https://w.namu.la/s/69493e71674f490fc8565157f87fc5d03ec665597e2997e62c7bf9b9127da40aedd0cec3a527fcdd0f584e00bc4817e27583ed02a06a93d6dffe3a3beaf2adee6aefe9294bfba8df605158bfe89fa978d99fabd6da717f82028c0cc4739cc57f"
            ),
            Category(
                "interior",
                63,
                "https://w.namu.la/s/69493e71674f490fc8565157f87fc5d03ec665597e2997e62c7bf9b9127da40aedd0cec3a527fcdd0f584e00bc4817e27583ed02a06a93d6dffe3a3beaf2adee6aefe9294bfba8df605158bfe89fa978d99fabd6da717f82028c0cc4739cc57f"
            ),
            Category(
                "interior",
                63,
                "https://w.namu.la/s/69493e71674f490fc8565157f87fc5d03ec665597e2997e62c7bf9b9127da40aedd0cec3a527fcdd0f584e00bc4817e27583ed02a06a93d6dffe3a3beaf2adee6aefe9294bfba8df605158bfe89fa978d99fabd6da717f82028c0cc4739cc57f"
            ),
            Category(
                "interior",
                63,
                "https://w.namu.la/s/69493e71674f490fc8565157f87fc5d03ec665597e2997e62c7bf9b9127da40aedd0cec3a527fcdd0f584e00bc4817e27583ed02a06a93d6dffe3a3beaf2adee6aefe9294bfba8df605158bfe89fa978d99fabd6da717f82028c0cc4739cc57f"
            ),
            Category(
                "interior",
                63,
                "https://w.namu.la/s/69493e71674f490fc8565157f87fc5d03ec665597e2997e62c7bf9b9127da40aedd0cec3a527fcdd0f584e00bc4817e27583ed02a06a93d6dffe3a3beaf2adee6aefe9294bfba8df605158bfe89fa978d99fabd6da717f82028c0cc4739cc57f"
            ),
            Category(
                "interior",
                63,
                "https://w.namu.la/s/69493e71674f490fc8565157f87fc5d03ec665597e2997e62c7bf9b9127da40aedd0cec3a527fcdd0f584e00bc4817e27583ed02a06a93d6dffe3a3beaf2adee6aefe9294bfba8df605158bfe89fa978d99fabd6da717f82028c0cc4739cc57f"
            ),
            Category(
                "interior",
                63,
                "https://w.namu.la/s/69493e71674f490fc8565157f87fc5d03ec665597e2997e62c7bf9b9127da40aedd0cec3a527fcdd0f584e00bc4817e27583ed02a06a93d6dffe3a3beaf2adee6aefe9294bfba8df605158bfe89fa978d99fabd6da717f82028c0cc4739cc57f"
            ),
            Category(
                "interior",
                63,
                "https://w.namu.la/s/69493e71674f490fc8565157f87fc5d03ec665597e2997e62c7bf9b9127da40aedd0cec3a527fcdd0f584e00bc4817e27583ed02a06a93d6dffe3a3beaf2adee6aefe9294bfba8df605158bfe89fa978d99fabd6da717f82028c0cc4739cc57f"
            ),
            Category(
                "interior",
                63,
                "https://w.namu.la/s/69493e71674f490fc8565157f87fc5d03ec665597e2997e62c7bf9b9127da40aedd0cec3a527fcdd0f584e00bc4817e27583ed02a06a93d6dffe3a3beaf2adee6aefe9294bfba8df605158bfe89fa978d99fabd6da717f82028c0cc4739cc57f"
            ),
            Category(
                "interior",
                63,
                "https://w.namu.la/s/69493e71674f490fc8565157f87fc5d03ec665597e2997e62c7bf9b9127da40aedd0cec3a527fcdd0f584e00bc4817e27583ed02a06a93d6dffe3a3beaf2adee6aefe9294bfba8df605158bfe89fa978d99fabd6da717f82028c0cc4739cc57f"
            ),
            Category(
                "interior",
                63,
                "https://w.namu.la/s/69493e71674f490fc8565157f87fc5d03ec665597e2997e62c7bf9b9127da40aedd0cec3a527fcdd0f584e00bc4817e27583ed02a06a93d6dffe3a3beaf2adee6aefe9294bfba8df605158bfe89fa978d99fabd6da717f82028c0cc4739cc57f"
            ),
            Category(
                "interior",
                63,
                "https://w.namu.la/s/69493e71674f490fc8565157f87fc5d03ec665597e2997e62c7bf9b9127da40aedd0cec3a527fcdd0f584e00bc4817e27583ed02a06a93d6dffe3a3beaf2adee6aefe9294bfba8df605158bfe89fa978d99fabd6da717f82028c0cc4739cc57f"
            ),
            Category(
                "interior",
                63,
                "https://w.namu.la/s/69493e71674f490fc8565157f87fc5d03ec665597e2997e62c7bf9b9127da40aedd0cec3a527fcdd0f584e00bc4817e27583ed02a06a93d6dffe3a3beaf2adee6aefe9294bfba8df605158bfe89fa978d99fabd6da717f82028c0cc4739cc57f"
            )
        )
    )

    fun clearSearchQuery() {
        searchQuery.value = ""
    }

    fun createCategory() {
        // todo
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

enum class DisplayMode {
    LIST, GRID
}