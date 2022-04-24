package com.samderra.archive.ui.view.category

import android.content.Intent
import android.view.Menu
import com.samderra.archive.R
import com.samderra.archive.base.BaseVmActivity
import com.samderra.archive.databinding.ActivityCategoryBinding
import com.samderra.archive.ui.adapter.ArticleGridAdapter
import com.samderra.archive.ui.model.article.Article
import com.samderra.archive.ui.model.main.Category
import com.samderra.archive.ui.view.article.ArticleActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class CategoryActivity() : BaseVmActivity<ActivityCategoryBinding>(
    R.layout.activity_category,
    CategoryViewModel::class.java
) {

    private val category: Category by lazy {
        intent.getSerializableExtra("category") as Category
    }

    fun CategoryViewModel.setObserves() {
        articleOpenEvent.observe(lifecycleOwner, ::openArticleActivity)
    }

    override fun initActivity() {
        viewModel.setObserves()
        binding.rvArticle.adapter = ArticleGridAdapter(viewModel)
        initCollapsingToolbar()
    }

    fun openArticleActivity(article: Article) {
        startActivity(Intent(this, ArticleActivity::class.java))
    }

    private fun initCollapsingToolbar() {
        toolbarTitle = category.title
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_category, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override val viewModel: CategoryViewModel by viewModel()
    override val toolbarId: Int = R.id.toolbar
}
