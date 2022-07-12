package com.samderra.archive.ui.model.article

import androidx.databinding.ObservableBoolean

data class SDRArticle(
    val articleId: Long,
    val thumbnailUrl: String,
    val linkUrl: String,
    val name: String = "",
    val description: String,
    val createdAt: String
) {
    val isChecked: ObservableBoolean = ObservableBoolean(false)

    companion object {
        fun dummy(): SDRArticle = SDRArticle(
            articleId = System.currentTimeMillis(),
            thumbnailUrl = "https://s3.orbi.kr/data/file/united/91a82be58e2eca9ea11f7652104b6304.jpg",
            linkUrl = "https://mathflat.com",
            name = "내일부터 갓생을 살겠습니다",
            description = "의지는 있나요? 의지는 있나요? 의지는 있나요? 의지는 있나요? 의지는 있나요? 의지는 있나요?",
//            createdAt = Date(System.currentTimeMillis())
            createdAt = "Date(System.currentTimeMillis())"
        )
    }
}