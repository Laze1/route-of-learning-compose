package com.example.myapplicationcompose.http

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class OkHttpRequest {
    companion object {
        private const val DEFAULT_TIMEOUT = 10L

        private var apiGithub: ApiGithub? = null

        private const val BASE_GITHUB_URL = "https://api.github.com"

        private const val BASE_MY_URL = "http://localhost:8080"

        @Synchronized
        fun getGithubApi(): ApiGithub {
            if (apiGithub == null) {
                apiGithub = createGithubApi()
            }
            return apiGithub!!
        }

        @Synchronized
        fun getMyApi(): ApiMy {
            return createMyApi()
        }

        private fun getClient() = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            .build()


        private fun createGithubApi(): ApiGithub {
            return Retrofit.Builder()
                .baseUrl(BASE_GITHUB_URL)
                .client(getClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiGithub::class.java)
        }

        private fun createMyApi(): ApiMy {
            return Retrofit.Builder()
                .baseUrl(BASE_MY_URL)
                .client(getClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiMy::class.java)
        }
    }

}