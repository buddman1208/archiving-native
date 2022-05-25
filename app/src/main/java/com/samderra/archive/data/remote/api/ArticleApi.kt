package com.samderra.archive.data.remote.api

import com.samderra.archive.data.remote.model.response.ArticleListResponse
import com.samderra.archive.data.remote.model.response.SDRResponse
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.HTTP
import retrofit2.http.Path

interface ArticleApi {
    @GET("/api/service/item/by-category/{categoryId}")
    fun getArticlesByCategory(
        @Path("categoryId") categoryId: Long,
    ): Observable<SDRResponse<ArticleListResponse>>

    @HTTP(method = "DELETE", path = "/api/service/item/by-id", hasBody = true)
    fun deleteArticles(
        @Body targetArticleIds: List<Long>
    ): Observable<SDRResponse<Boolean>>
}