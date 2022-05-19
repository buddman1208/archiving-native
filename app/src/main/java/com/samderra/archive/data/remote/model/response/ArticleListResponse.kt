package com.samderra.archive.data.remote.model.response

import com.samderra.archive.data.remote.model.Article

data class ArticleListResponse(
    val items: List<Article>
)