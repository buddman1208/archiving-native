package com.samderra.archive.data.remote.source

import com.samderra.archive.data.remote.api.CategoryApi
import com.samderra.archive.ui.model.main.SDRCategory
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class CategoryDataSource(
    private val categoryApi: CategoryApi
) {
    fun getCategories(cursor: Int = 0, query: String = ""): Single<List<SDRCategory>> {
        return categoryApi.getCategories(cursor, query)
            .map { it.result.categories.map { dto -> SDRCategory.fromDto(dto) } }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}