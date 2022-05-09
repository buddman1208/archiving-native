package com.samderra.archive.data.remote.api

import com.samderra.archive.data.remote.model.User
import com.samderra.archive.data.remote.model.request.AuthTokenRequest
import com.samderra.archive.data.remote.model.response.SDRResponse
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {

    @POST("/api/auth/token")
    fun getToken(
        @Body request: AuthTokenRequest
    ): Single<SDRResponse<User>>

}