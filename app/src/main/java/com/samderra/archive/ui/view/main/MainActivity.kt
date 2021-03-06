package com.samderra.archive.ui.view.main

import android.content.Intent
import android.util.Log
import android.widget.Toast
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
    private var lastPressedTime: Long = System.currentTimeMillis()
    private val categoryAdapter: CategoryAdapter by lazy { CategoryAdapter(viewModel) }

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
            this@MainActivity.run {
                when (it) {
                    MainEvent.SHOW_POST_ACTIVITY -> {}
                    MainEvent.SHOW_MAIN_OPTIONS -> showMainOptions()
                    MainEvent.CATEGORY_DELETE_CONFIRM -> updateDeleteMode(false)
                }
            }
        }
    }

    override fun initActivity() {
        Log.e("asdf", "${viewModel.isDeleteMode}")
        startActivity(
            Intent(this@MainActivity, TutorialActivity::class.java)
        )
        viewModel.setObserves()
        binding.rvMain.adapter = categoryAdapter
        binding.searchResultContainer.rvSearchResult.adapter = CategorySearchAdapter(viewModel)
    }

    private fun showMainOptions() {
        MaterialAlertDialogBuilder(this@MainActivity)
            .setTitle("??????")
            .setItems(
                when (viewModel.displayMode.value ?: return) {
                    DisplayMode.GRID -> R.array.main_settings_listview
                    DisplayMode.LIST -> R.array.main_settings_gridview
                }
            ) { _, which ->
                when (which) {
                    0 -> showSortOptions()
                    1 -> viewModel.switchDisplayMode()
                    2 -> updateDeleteMode(true)
                }
            }
            .show()
    }

    private fun showSortOptions() {
        MaterialAlertDialogBuilder(this@MainActivity)
            .setTitle("?????? ??????")
            .setItems(R.array.sort_options) { _, which ->
                viewModel.changeSortOptions(SortOption.indexOf(which))
            }
            .show()
    }

    private fun updateDeleteMode(value: Boolean) {
        categoryAdapter.updateDeleteMode(value)
        viewModel.isDeleteMode.value = value
        if (!value) {
            viewModel.clearClickedItems()
        }
        Log.e("asdf", "${viewModel.isDeleteMode}")
    }

    private fun openCategoryActivity(category: SDRCategory) {
        startActivity(
            Intent(this, CategoryActivity::class.java)
                .putExtra("category", category)
        )
    }

    override fun onBackPressed() {
        if (System.currentTimeMillis() - lastPressedTime > 1000L) {
            Toast.makeText(
                this@MainActivity,
                getString(R.string.double_tap_to_exit),
                Toast.LENGTH_SHORT
            ).show()
            lastPressedTime = System.currentTimeMillis()
        } else finish()
    }

    override val viewModel: MainViewModel by viewModel()
    override val toolbarId: Int = 0
}

enum class SortOption(
    val value: Int
) {
    // ?????? ??? / ?????? ?????? ??? / ????????? ?????? ??? / ?????? ?????? ??? ??? / ?????? ?????? ??? ???
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