package com.samderra.archive.ui.model.main

import java.io.Serializable

data class Category(
    val title: String,
    val contentSize: Int,
    val thumbnailUrl: String
) : Serializable {
    companion object {
        fun dummy(): Category = Category(
            "인테리어",
            63,
            "https://w.namu.la/s/69493e71674f490fc8565157f87fc5d03ec665597e2997e62c7bf9b9127da40aedd0cec3a527fcdd0f584e00bc4817e27583ed02a06a93d6dffe3a3beaf2adee6aefe9294bfba8df605158bfe89fa978d99fabd6da717f82028c0cc4739cc57f"
        )
    }
}