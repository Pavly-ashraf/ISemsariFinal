package com.example.isemsari.services

import android.os.Build
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {
    private const val URL = "https://isemsari.com/"
    private val logger: HttpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    val headerInterceptor = Interceptor { chain ->
        var request = chain.request()
        request = request.newBuilder().addHeader("Content-Type", "application/json")
            .build()
        chain.proceed(request)
    }

    private val okHttp: OkHttpClient.Builder = OkHttpClient.Builder().addInterceptor(
        headerInterceptor
    ).addInterceptor(logger)
    val builder: Retrofit.Builder = Retrofit.Builder().baseUrl(URL).client(okHttp.build()).addConverterFactory(GsonConverterFactory.create())

}
