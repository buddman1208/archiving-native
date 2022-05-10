package com.samderra.archive.data.local.pref

import android.content.Context
import androidx.core.content.edit
import java.util.*

class UserPreference(
    private val applicationContext: Context
) : SDRPreference.UserInfo {
    private val userInfoPref =
        applicationContext.getSharedPreferences(
            UserInfoPreferenceKey.PREF_USER_INFO,
            Context.MODE_PRIVATE
        )

    override val id: Long
        get() = userInfoPref.getLong(UserInfoPreferenceKey.ID, 0)
    override val userId: Long
        get() = userInfoPref.getLong(UserInfoPreferenceKey.USER_ID, 0)
    override val name: String
        get() = userInfoPref.getString(UserInfoPreferenceKey.NAME, "") ?: ""
    override val description: String
        get() = userInfoPref.getString(UserInfoPreferenceKey.DESCRIPTION, "") ?: ""
    override val createdAt: Date
        get() = Calendar.getInstance().apply {
            timeInMillis =
                userInfoPref.getLong(UserInfoPreferenceKey.CREATED_AT, System.currentTimeMillis())
        }.time

    override fun clearPref() {
        userInfoPref.edit {
            clear()
        }
    }


    object UserInfoPreferenceKey {
        const val PREF_USER_INFO = "pref_user_info"
        const val ID = "key_id"
        const val USER_ID = "user_id"
        const val NAME = "name"
        const val DESCRIPTION = "description"
        const val CREATED_AT = "created_at"
    }
}
