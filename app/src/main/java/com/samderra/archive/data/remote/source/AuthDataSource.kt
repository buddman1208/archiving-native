package com.samderra.archive.data.remote.source

import com.samderra.archive.data.remote.api.AuthApi
import com.samderra.archive.data.remote.model.User
import com.samderra.archive.data.remote.model.request.AuthTokenRequest
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AuthDataSource(
    private val authApi: AuthApi
) {
    fun getToken(request: AuthTokenRequest): Observable<User> {
        return authApi.getToken(request)
            .map { it.result }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

}