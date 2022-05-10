package com.samderra.archive.data.remote.model

import com.samderra.archive.ui.model.main.SDRCategory

data class Category(
    val id: Long,
    val name: String,
    val count: Int,
    val thumbnail: String
)

fun Category.toSDRCategory(): SDRCategory {
    return SDRCategory(
        id = this.id,
        title = this.name,
        contentSize = this.count,
        thunbnail = this.thumbnail
    )
}