package com.samderra.archive.data.remote.model

import com.google.gson.annotations.SerializedName
import com.samderra.archive.ui.model.article.SDRArticle
import java.util.*

data class Article(
    @SerializedName("id")
    val articleId: Long,
    val userId: Long,
    val categoryIds: List<Long>,
    val name: String,
    val description: String,
    val createdAt: Date
)

fun Article.toSDRArticle(): SDRArticle {
    return SDRArticle(
        articleId = this.articleId,
        thumbnailUrl = "",
        linkUrl = "",
        name = this.name,
        description = this.description,
        createdAt = this.createdAt
    )
}