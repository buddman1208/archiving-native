package com.samderra.archive.ui.view.main

import android.content.Intent
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.samderra.archive.R
import com.samderra.archive.base.BaseVmActivity
import com.samderra.archive.databinding.ActivityMainBinding
import com.samderra.archive.ui.adapter.CategoryAdapter
import com.samderra.archive.ui.adapter.CategorySearchAdapter
import com.samderra.archive.ui.view.category.CategoryActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity() : BaseVmActivity<ActivityMainBinding>(
    R.layout.activity_main,
    MainViewModel::class.java
) {

    private fun MainViewModel.setObserves() {
        displayMode.observe(lifecycleOwner, {
            (binding.rvMain.adapter as CategoryAdapter).updateDisplayMode(it)
            binding.rvMain.layoutManager = when (it) {
                DisplayMode.GRID -> GridLayoutManager(this@MainActivity, 2)
                DisplayMode.LIST -> LinearLayoutManager(this@MainActivity)
            }
        })
    }

    override fun initActivity() {
        viewModel.setObserves()
        binding.rvMain.adapter = CategoryAdapter(viewModel)
        binding.searchResultContainer.rvSearchResult.adapter = CategorySearchAdapter(viewModel)
        startActivity(
            Intent(this, CategoryActivity::class.java)
        )
    }

    override val viewModel: MainViewModel by viewModel()
    override val toolbarId: Int = 0
}