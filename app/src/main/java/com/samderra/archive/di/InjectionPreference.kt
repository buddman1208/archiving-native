package com.samderra.archive.di

import com.samderra.archive.data.local.pref.SDRPreference
import com.samderra.archive.data.local.pref.UserPreference
import org.koin.dsl.module

val preferenceModule = module {
    single<SDRPreference.UserInfo> { UserPreference(get()) }
}