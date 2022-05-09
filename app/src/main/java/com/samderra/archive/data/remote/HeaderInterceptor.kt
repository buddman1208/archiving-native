package com.samderra.archive.data.remote

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
//        val token = PreferencesController.userInfoPref.token
        builder.removeHeader("token")
        builder.addHeader("x-auth-token", "token")
        builder.removeHeader("x-platform")
        builder.addHeader("x-platform", "ANDROID")
        return chain.proceed(builder.build())
    }
}