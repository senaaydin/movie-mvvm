package com.sena.movieapp.util

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class TokenInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        if (request.header("No-Authentication") == null) {
            val url = request.url.newBuilder()
                .addQueryParameter("api_key", "26bff72894fa7f1200fdf18f01845c59")
                .build()
            request = request.newBuilder()
                .url(url)
                .build()
        }
        return chain.proceed(request)
    }
}