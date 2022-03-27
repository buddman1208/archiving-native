package com.samderra.archive.ui.view.category

import android.view.Menu
import com.samderra.archive.R
import com.samderra.archive.base.BaseVmActivity
import com.samderra.archive.databinding.ActivityCategoryBinding
import com.samderra.archive.ui.adapter.ArticleGridAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class CategoryActivity() : BaseVmActivity<ActivityCategoryBinding>(
    R.layout.activity_category,
    CategoryViewModel::class.java
) {

    fun CategoryViewModel.setObserves() {

    }

    override fun initActivity() {
        viewModel.setObserves()
        binding.rvArticle.adapter = ArticleGridAdapter(viewModel)
        initCollapsingToolbar()
    }

    private fun initCollapsingToolbar() {
        toolbarTitle = ""
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_category, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override val viewModel: CategoryViewModel by viewModel()
    override val toolbarId: Int = R.id.toolbar
}
