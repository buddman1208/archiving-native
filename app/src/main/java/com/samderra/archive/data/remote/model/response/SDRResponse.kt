package com.samderra.archive.data.remote.model.response

data class SDRResponse<T>(
    val status: String,
    val result: T,
    val description: String?
)