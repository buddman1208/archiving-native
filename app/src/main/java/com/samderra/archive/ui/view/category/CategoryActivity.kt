package com.samderra.archive.ui.view.category

import android.content.Intent
import android.view.Menu
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.samderra.archive.R
import com.samderra.archive.base.BaseVmActivity
import com.samderra.archive.databinding.ActivityCategoryBinding
import com.samderra.archive.ui.adapter.ArticleGridAdapter
import com.samderra.archive.ui.model.article.SDRArticle
import com.samderra.archive.ui.model.main.SDRCategory
import com.samderra.archive.ui.view.article.ArticleActivity
import com.samderra.archive.ui.view.main.SortOption
import com.samderra.archive.util.observeEvent
import org.koin.androidx.viewmodel.ext.android.viewModel

class CategoryActivity() : BaseVmActivity<ActivityCategoryBinding>(
    R.layout.activity_category,
    CategoryViewModel::class.java
) {

    private val category: SDRCategory by lazy {
        intent.getSerializableExtra("category") as SDRCategory
    }

    fun CategoryViewModel.setObserves() {
        articleOpenEvent.observe(lifecycleOwner, ::openArticleActivity)
        categoryActions.observeEvent(lifecycleOwner) {
            when (it) {
                CategoryActions.OPEN_SORT_OPTIONS -> this@CategoryActivity.showSortOptions()
            }
        }
    }

    override fun initActivity() {
        viewModel.setObserves()
        binding.rvArticle.adapter = ArticleGridAdapter(viewModel)
        initCollapsingToolbar()
    }

    fun openArticleActivity(article: SDRArticle) {
        Intent(this, ArticleActivity::class.java).run {
            putExtra("category", category)
            startActivity(this)
        }
    }

    private fun showSortOptions() {
        MaterialAlertDialogBuilder(this@CategoryActivity)
            .setTitle("정렬 순서")
            .setItems(R.array.sort_options) { _, which ->
                viewModel.changeSortOptions(SortOption.indexOf(which))
            }
            .show()
    }


    private fun initCollapsingToolbar() {
        viewModel.category.value = category
        viewModel.init()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_category, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override val viewModel: CategoryViewModel by viewModel()
    override val toolbarId: Int = R.id.toolbar
}
