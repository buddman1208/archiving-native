package com.samderra.archive.ui.adapter

import com.samderra.archive.R
import com.samderra.archive.base.BaseRecyclerAdapter
import com.samderra.archive.databinding.ItemArticleListBinding
import com.samderra.archive.ui.model.article.SDRArticle
import com.samderra.archive.ui.view.article.ArticleViewModel

class ArticleListAdapter(vm: ArticleViewModel) :
    BaseRecyclerAdapter<SDRArticle, ItemArticleListBinding>(
        R.layout.item_article_list, vm
    )