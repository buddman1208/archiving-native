package com.samderra.archive.ui.adapter

import com.samderra.archive.R
import com.samderra.archive.base.BaseRecyclerAdapter
import com.samderra.archive.databinding.ItemArticleGridBinding
import com.samderra.archive.ui.model.article.SDRArticle
import com.samderra.archive.ui.view.category.CategoryViewModel

class ArticleGridAdapter(vm: CategoryViewModel) :
    BaseRecyclerAdapter<SDRArticle, ItemArticleGridBinding>(
        R.layout.item_article_grid, vm
    )