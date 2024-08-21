package io.github.hugoangeles0810.pixplore.infrastructure.interceptors

import io.github.hugoangeles0810.pixplore.BuildConfig.UNSPLASH_API_KEY
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

private const val Authorization = "Authorization"
private const val ClientId = "Client-ID"

class UnsplashAuthorizationInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest = chain.request().newBuilder()
            .header(Authorization, "$ClientId $UNSPLASH_API_KEY")
            .build()

        return chain.proceed(newRequest)
    }
}