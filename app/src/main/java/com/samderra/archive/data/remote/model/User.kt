package com.samderra.archive.data.remote.model

import java.util.*

data class User(
    val token: String,
    val id: Long,
    val userId: Long,
    val categoryIds: List<Long>,
    val name: String,
    val description: String,
    val createdAt: Date
)