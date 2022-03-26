package com.samderra.archive.ui.view.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.samderra.archive.R
import com.samderra.archive.base.BaseRecyclerAdapter
import com.samderra.archive.base.BaseVmActivity
import com.samderra.archive.databinding.ActivityMainBinding
import com.samderra.archive.databinding.ItemCategorySearchBinding
import com.samderra.archive.databinding.ItemMainGridBinding
import com.samderra.archive.databinding.ItemMainListBinding
import com.samderra.archive.ui.model.main.Category
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity() : BaseVmActivity<ActivityMainBinding>(
    R.layout.activity_main,
    MainViewModel::class.java
) {

    fun MainViewModel.setObserves() {
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
    }

    override val viewModel: MainViewModel by viewModel()
    override val toolbarId: Int = 0
}

class CategoryAdapter(
    private val vm: MainViewModel
) : RecyclerView.Adapter<BaseRecyclerAdapter.ViewHolder>() {
    private val items = ObservableArrayList<Any>()
    private var displayMode: DisplayMode = DisplayMode.GRID

    fun updateDisplayMode(mode: DisplayMode) {
        displayMode = mode
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return displayMode.ordinal
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseRecyclerAdapter.ViewHolder {
        return when (viewType) {
            DisplayMode.GRID.ordinal -> BaseRecyclerAdapter.ViewHolder(
                DataBindingUtil.inflate<ItemMainGridBinding>(
                    LayoutInflater.from(parent.context), R.layout.item_main_grid, parent, false
                )
            )
            DisplayMode.LIST.ordinal -> BaseRecyclerAdapter.ViewHolder(
                DataBindingUtil.inflate<ItemMainListBinding>(
                    LayoutInflater.from(parent.context), R.layout.item_main_list, parent, false
                )
            )
            else -> BaseRecyclerAdapter.ViewHolder(
                DataBindingUtil.inflate<ItemCategorySearchBinding>(
                    LayoutInflater.from(parent.context),
                    R.layout.item_category_search,
                    parent,
                    false
                )
            )
        }
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: BaseRecyclerAdapter.ViewHolder, position: Int) {
        holder.bind(items[position], vm)
    }

    fun updateItems(updateItems: List<Category>) {
        val size = items.size
        items.clear()
        notifyItemRangeRemoved(0, size)
        items.addAll(updateItems)
        notifyItemRangeInserted(0, updateItems.size)
    }
}


class CategorySearchAdapter(vm: MainViewModel) :
    BaseRecyclerAdapter<Category, ItemCategorySearchBinding>(
        R.layout.item_category_search, vm
    )