package com.samderra.archive.ui.view.splash

import androidx.lifecycle.MutableLiveData
import com.samderra.archive.base.BaseViewModel
import com.samderra.archive.data.local.pref.PreferenceManager
import com.samderra.archive.data.remote.model.request.AuthTokenRequest
import com.samderra.archive.data.remote.source.AuthDataSource
import com.samderra.archive.util.Event
import com.samderra.archive.util.emit

class SplashViewModel(
    val authDataSource: AuthDataSource
) : BaseViewModel() {

    val event: MutableLiveData<Event<SplashEvent>> = MutableLiveData()

    init {
        PreferenceManager.userPref.token = ""
        authDataSource
            .getToken(AuthTokenRequest("0"))
            .subscribeAuto {
                println(it.toString())
                messageEvent.value = Event("${it.name}님 환영합니다.")
                PreferenceManager.userPref.token = it.token

                event.emit(SplashEvent.NEXT)
            }

    }
}

enum class SplashEvent {
    NEXT
}
