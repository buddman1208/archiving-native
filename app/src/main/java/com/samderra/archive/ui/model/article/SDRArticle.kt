package com.samderra.archive.ui.model.article

import java.util.*

data class SDRArticle(
    val articleId: Long,
    val thumbnailUrl: String,
    val linkUrl: String,
    val title: String = "",
    val content: String,
    val date: Date
) {
    companion object {
        fun dummy(): SDRArticle = SDRArticle(
            articleId = System.currentTimeMillis(),
            thumbnailUrl = "https://s3.orbi.kr/data/file/united/91a82be58e2eca9ea11f7652104b6304.jpg",
            linkUrl = "https://mathflat.com",
            title = "내일부터 갓생을 살겠습니다",
            content = "의지는 있나요? 의지는 있나요? 의지는 있나요? 의지는 있나요? 의지는 있나요? 의지는 있나요?",
            date = Date(System.currentTimeMillis())
        )
    }
}