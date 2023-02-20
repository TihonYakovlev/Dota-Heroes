package com.tihonyakovlev.dotaheroes.di

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ProvideRetrofit {
    fun provideRetrofit(): Retrofit {

        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(300, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()


        return Retrofit.Builder()
            .baseUrl("https://dota2-heroes.p.rapidapi.com/")
            .client(okHttpClient)
            .addConverterFactory(
                GsonConverterFactory.create()
            ).build()
    }
}