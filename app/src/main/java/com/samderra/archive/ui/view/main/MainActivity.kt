package com.samderra.archive.ui.view.main

import android.content.Intent
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.samderra.archive.R
import com.samderra.archive.base.BaseVmActivity
import com.samderra.archive.databinding.ActivityMainBinding
import com.samderra.archive.ui.adapter.CategoryAdapter
import com.samderra.archive.ui.adapter.CategorySearchAdapter
import com.samderra.archive.ui.model.main.SDRCategory
import com.samderra.archive.ui.view.category.CategoryActivity
import com.samderra.archive.ui.view.tutorial.TutorialActivity
import com.samderra.archive.util.observeEvent
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity() : BaseVmActivity<ActivityMainBinding>(
    R.layout.activity_main,
    MainViewModel::class.java
) {

    private fun MainViewModel.setObserves() {
        displayMode.observe(lifecycleOwner) {
            (binding.rvMain.adapter as CategoryAdapter).updateDisplayMode(it)
            binding.rvMain.layoutManager = when (it) {
                DisplayMode.GRID -> GridLayoutManager(this@MainActivity, 2)
                DisplayMode.LIST -> LinearLayoutManager(this@MainActivity)
            }
        }
        categoryOpenEvent.observe(lifecycleOwner, ::openCategoryActivity)

        event.observeEvent(lifecycleOwner) {
            when (it) {
                MainEvent.OPEN_SORT_OPTIONS -> this@MainActivity.showSortOptions()
            }
        }
    }

    override fun initActivity() {
        startActivity(
            Intent(this@MainActivity, TutorialActivity::class.java)
        )
        viewModel.setObserves()
        binding.rvMain.adapter = CategoryAdapter(viewModel)
        binding.searchResultContainer.rvSearchResult.adapter = CategorySearchAdapter(viewModel)
    }

    private fun showSortOptions() {
        MaterialAlertDialogBuilder(this@MainActivity)
            .setTitle("정렬 순서")
            .setItems(R.array.sort_options) { _, which ->
                viewModel.changeSortOptions(SortOption.indexOf(which))
            }
            .show()
    }

    private fun openCategoryActivity(category: SDRCategory) {
        startActivity(
            Intent(this, CategoryActivity::class.java)
                .putExtra("category", category)
        )
    }

    override val viewModel: MainViewModel by viewModel()
    override val toolbarId: Int = 0
}

enum class SortOption(
    val value: Int
) {
    // 이름 순 / 최근 저장 순 / 오래된 저장 순 / 가장 많이 본 순 / 가장 적게 본 순
    NAME(0),
    RECENT(1),
    OLD(2),
    MOST_VIEWED(3),
    LEAST_VIEWED(4);

    companion object {
        fun indexOf(index: Int): SortOption {
            return values().find { index == it.value } ?: NAME
        }
    }
}