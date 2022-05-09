package com.samderra.archive.ui.adapter

import com.samderra.archive.R
import com.samderra.archive.base.BaseRecyclerAdapter
import com.samderra.archive.databinding.ItemCategorySearchBinding
import com.samderra.archive.ui.model.main.SDRCategory
import com.samderra.archive.ui.view.main.MainViewModel

class CategorySearchAdapter(vm: MainViewModel) :
    BaseRecyclerAdapter<SDRCategory, ItemCategorySearchBinding>(
        R.layout.item_category_search, vm
    )