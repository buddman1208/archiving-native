package com.samderra.archive.data.remote.api

import com.samderra.archive.data.remote.model.response.ArticleListResponse
import com.samderra.archive.data.remote.model.response.SDRResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface ArticleApi {
    @GET("/api/service/item/by-category/{categoryId}")
    fun getArticlesByCategory(
        @Path("categoryId") categoryId: Long,
    ): Observable<SDRResponse<ArticleListResponse>>
}