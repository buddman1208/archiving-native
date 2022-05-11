package com.samderra.archive.data.local.pref

import android.content.Context
import androidx.core.content.edit
import java.util.*

class UserPreference(
    applicationContext: Context
) : SDRPreference.UserInfo {
    private val userInfoPref = applicationContext.getSharedPreferences(
        UserInfoPreferenceKey.PREF_USER_INFO,
        Context.MODE_PRIVATE
    )

    override var token: String
        get() = userInfoPref.getString(UserInfoPreferenceKey.TOKEN, "") ?: ""
        set(value) {
            userInfoPref.edit { putString(UserInfoPreferenceKey.TOKEN, value) }
        }

    override var id: Long
        get() = userInfoPref.getLong(UserInfoPreferenceKey.ID, 0)
        set(value) {
            userInfoPref.edit { putLong(UserInfoPreferenceKey.ID, value) }
        }
    override var userId: Long
        get() = userInfoPref.getLong(UserInfoPreferenceKey.USER_ID, 0)
        set(value) {
            userInfoPref.edit { putLong(UserInfoPreferenceKey.USER_ID, value) }
        }
    override var name: String
        get() = userInfoPref.getString(UserInfoPreferenceKey.NAME, "") ?: ""
        set(value) {
            userInfoPref.edit { putString(UserInfoPreferenceKey.NAME, value) }
        }
    override var description: String
        get() = userInfoPref.getString(UserInfoPreferenceKey.DESCRIPTION, "") ?: ""
        set(value) {
            userInfoPref.edit { putString(UserInfoPreferenceKey.DESCRIPTION, value) }
        }
    override var createdAt: Date
        get() = Calendar.getInstance().apply {
            timeInMillis =
                userInfoPref.getLong(UserInfoPreferenceKey.CREATED_AT, System.currentTimeMillis())
        }.time
        set(value) {
            userInfoPref.edit { putLong(UserInfoPreferenceKey.CREATED_AT, value.time) }
        }

    override fun clearPref() {
        userInfoPref.edit {
            clear()
        }
    }


    object UserInfoPreferenceKey {
        const val PREF_USER_INFO = "pref_user_info"
        const val TOKEN = "token"
        const val ID = "key_id"
        const val USER_ID = "user_id"
        const val NAME = "name"
        const val DESCRIPTION = "description"
        const val CREATED_AT = "created_at"
    }
}
