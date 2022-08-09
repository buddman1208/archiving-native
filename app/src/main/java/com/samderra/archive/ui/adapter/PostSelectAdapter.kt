package com.samderra.archive.ui.adapter

import com.samderra.archive.R
import com.samderra.archive.base.BaseRecyclerAdapter
import com.samderra.archive.databinding.ItemCategorySelectBinding
import com.samderra.archive.ui.model.main.SDRCategory
import com.samderra.archive.ui.view.post.fromshare.PostFromShareViewModel

class CategorySelectAdapter(
    vm: PostFromShareViewModel
) : BaseRecyclerAdapter<SDRCategory, ItemCategorySelectBinding>(
    R.layout.item_category_select, vm
)