package com.samderra.archive.data.local.pref

import java.util.*

interface SDRPreference {
    interface UserInfo {
        var token: String
        var id: Long
        var userId: Long
        var name: String
        var description: String
        var createdAt: Date

        fun clearPref()
    }
}