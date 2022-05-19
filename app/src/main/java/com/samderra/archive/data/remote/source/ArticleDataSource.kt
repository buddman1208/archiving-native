package com.samderra.archive.data.remote.source

import com.samderra.archive.data.remote.api.ArticleApi
import com.samderra.archive.data.remote.model.toSDRArticle
import com.samderra.archive.ui.model.article.SDRArticle
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ArticleDataSource(
    private val articleApi: ArticleApi
) {
    fun getArticlesByCategory(categoryId: Long): Observable<List<SDRArticle>> {
        return articleApi.getArticlesByCategory(categoryId)
            .map { it.result.items.map { article -> article.toSDRArticle() } }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}
