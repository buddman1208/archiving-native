package com.samderra.archive.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableBoolean
import androidx.recyclerview.widget.RecyclerView
import com.samderra.archive.BR
import com.samderra.archive.R
import com.samderra.archive.base.BaseRecyclerAdapter
import com.samderra.archive.databinding.ItemCategorySearchBinding
import com.samderra.archive.databinding.ItemMainGridBinding
import com.samderra.archive.databinding.ItemMainListBinding
import com.samderra.archive.ui.model.main.SDRCategory
import com.samderra.archive.ui.view.main.DisplayMode
import com.samderra.archive.ui.view.main.MainViewModel

class CategoryAdapter(
    private val vm: MainViewModel
) : RecyclerView.Adapter<BaseRecyclerAdapter.ViewHolder>() {
    private val items = ObservableArrayList<Any>()
    private var displayMode: DisplayMode = DisplayMode.GRID
    private val isDeleteMode: ObservableBoolean = ObservableBoolean(false)

    fun updateDisplayMode(mode: DisplayMode) {
        displayMode = mode
        notifyDataSetChanged()
    }

    fun updateDeleteMode(value: Boolean) = isDeleteMode.set(value)

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
        holder.bindVariable(BR.isDeleteMode, isDeleteMode)
    }

    fun updateItems(updateItems: List<SDRCategory>) {
        val size = items.size
        items.clear()
        notifyItemRangeRemoved(0, size)
        items.addAll(updateItems)
        notifyItemRangeInserted(0, updateItems.size)
    }
}