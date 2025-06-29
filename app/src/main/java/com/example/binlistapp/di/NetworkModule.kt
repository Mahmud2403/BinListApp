package com.example.binlistapp.di

import com.example.binlistapp.data.remote.BinApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {

    single {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    single {
        OkHttpClient.Builder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl("https://lookup.binlist.net/")
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single<BinApi> {
        get<Retrofit>().create(BinApi::class.java)
    }
}