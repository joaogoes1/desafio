package com.picpay.desafio.android.network.di

import android.app.Application
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.picpay.desafio.android.network.service.PicPayService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    @Singleton
    fun provideMoshi(): Gson = GsonBuilder().create()

    @Provides
    @Singleton
    fun providePicPayService(application: Application): PicPayService = PicPayService(application)

    @Provides
    @Singleton
    fun provideRetrofit(picPayService: PicPayService, gson: Gson): Retrofit =
        picPayService.createRetrofit(gson)
}