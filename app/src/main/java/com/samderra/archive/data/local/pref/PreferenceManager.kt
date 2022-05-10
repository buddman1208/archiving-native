package com.samderra.archive.data.local.pref

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


object PreferenceManager : KoinComponent {
    val userPref: SDRPreference.UserInfo by inject()
}