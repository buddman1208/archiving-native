package com.samderra.archive.ui.view.article

import com.samderra.archive.R
import com.samderra.archive.base.BaseVmActivity
import com.samderra.archive.databinding.ActivityArticleBinding
import com.samderra.archive.ui.adapter.ArticleListAdapter
import com.samderra.archive.ui.model.main.SDRCategory
import org.koin.androidx.viewmodel.ext.android.viewModel

class ArticleActivity() : BaseVmActivity<ActivityArticleBinding>(
    R.layout.activity_article,
    ArticleViewModel::class.java
) {

    private val category: SDRCategory by lazy {
        intent.getSerializableExtra("category") as SDRCategory
    }

    fun ArticleViewModel.setObserves() {

    }

    override fun initActivity() {
        viewModel.setObserves()
        binding.rvArticle.adapter = ArticleListAdapter(viewModel)
        toolbarTitle = category.title
    }

    override val viewModel: ArticleViewModel by viewModel()
    override val toolbarId: Int = R.id.toolbar
}
