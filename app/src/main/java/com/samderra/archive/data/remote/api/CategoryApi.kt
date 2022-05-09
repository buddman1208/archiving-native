package com.samderra.archive.data.remote.api

import com.samderra.archive.data.remote.model.response.CategoryListResponse
import com.samderra.archive.data.remote.model.response.SDRResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface CategoryApi {
    @GET("/api/service/category")
    fun getCategories(
        @Query("cursor") cursor: Int,
        @Query("query") query: String,
    ): Single<SDRResponse<CategoryListResponse>>
}