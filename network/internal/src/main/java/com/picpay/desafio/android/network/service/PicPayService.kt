package com.picpay.desafio.android.network.service

import android.app.Application
import com.google.gson.Gson
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import javax.inject.Inject


class PicPayService @Inject constructor(private val application: Application) {

    fun createRetrofit(gson: Gson): Retrofit {
        val okHttp: OkHttpClient =
            OkHttpClient
                .Builder()
                .cache(
                    Cache(
                        directory = File(application.cacheDir, CACHE_PATH),
                        maxSize = CACHE_SIZE
                    )
                )
                .build()

        return Retrofit.Builder()
            .baseUrl(BASE_PATH)
            .client(okHttp)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    companion object {
        private const val BASE_PATH = "https://609a908e0f5a13001721b74e.mockapi.io/picpay/api/"
        private const val CACHE_PATH = "http_cache"
        private const val CACHE_SIZE = 50L * 1024L * 1024L // 50 MiB
    }
}