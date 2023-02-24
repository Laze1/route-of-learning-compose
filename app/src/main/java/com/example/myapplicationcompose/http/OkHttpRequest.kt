package com.example.myapplicationcompose.http

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class OkHttpRequest {
    companion object {
        private const val DEFAULT_TIMEOUT = 10L

        private var api: Api? = null

        private const val BASE_GITHUB_URL = "https://api.github.com/"

        @Synchronized
        fun getGithubApi(): Api {
            if (api == null) {
                api = createGithubApi()
            }
            return api!!
        }

        private fun getClient() = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            .build()


        private fun createGithubApi(): Api {
            return Retrofit.Builder()
                .baseUrl(BASE_GITHUB_URL)
                .client(getClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Api::class.java)
        }
    }

}