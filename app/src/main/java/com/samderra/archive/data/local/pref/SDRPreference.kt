package com.samderra.archive.data.local.pref

import java.util.*

interface SDRPreference {
    interface UserInfo {
        val id: Long
        val userId: Long
        val name: String
        val description: String
        val createdAt: Date

        fun clearPref()
    }
}