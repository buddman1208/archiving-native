package com.samderra.archive.ui.view.article

import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.samderra.archive.R
import com.samderra.archive.base.BaseVmActivity
import com.samderra.archive.databinding.ActivityArticleBinding
import com.samderra.archive.ui.adapter.ArticleListAdapter
import com.samderra.archive.ui.model.article.SDRArticle
import com.samderra.archive.ui.model.main.SDRCategory
import com.samderra.archive.util.observeEvent
import org.koin.androidx.viewmodel.ext.android.viewModel

class ArticleActivity() : BaseVmActivity<ActivityArticleBinding>(
    R.layout.activity_article,
    ArticleViewModel::class.java
) {

    private val category: SDRCategory by lazy {
        intent.getSerializableExtra("category") as SDRCategory
    }

    fun ArticleViewModel.setObserves() {
        articleToDelete.observeEvent(lifecycleOwner, ::showArticleDeleteDialog)
    }

    override fun initActivity() {
        viewModel.run {
            setObserves()
            categoryId = category.id
            initData()
        }
        binding.rvArticle.adapter = ArticleListAdapter(viewModel)
        toolbarTitle = category.title
    }

    private fun showArticleDeleteDialog(article: SDRArticle) {
        MaterialAlertDialogBuilder(this@ArticleActivity)
            .setTitle(getString(R.string.text_article_delete))
            .setMessage("해당 게시물을 삭제하시겠습니까?")
            .setPositiveButton("확인") { dialog, which -> viewModel.deleteArticle(article) }
            .show()
    }

    override val viewModel: ArticleViewModel by viewModel()
    override val toolbarId: Int = R.id.toolbar
}
