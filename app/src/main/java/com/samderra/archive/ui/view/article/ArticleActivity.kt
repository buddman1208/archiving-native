package com.samderra.archive.ui.view.article

import android.view.Menu
import com.samderra.archive.R
import com.samderra.archive.base.BaseVmActivity
import com.samderra.archive.databinding.ActivityArticleBinding
import com.samderra.archive.ui.adapter.ArticleListAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class ArticleActivity() : BaseVmActivity<ActivityArticleBinding>(
    R.layout.activity_article,
    ArticleViewModel::class.java
) {

    fun ArticleViewModel.setObserves() {

    }

    override fun initActivity() {
        viewModel.setObserves()
        binding.rvArticle.adapter = ArticleListAdapter(viewModel)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_category, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override val viewModel: ArticleViewModel by viewModel()
    override val toolbarId: Int = R.id.toolbar
}
