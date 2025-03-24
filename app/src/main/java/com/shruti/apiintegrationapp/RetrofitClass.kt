package com.shruti.apiintegrationapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClass {
    val instance: ApiInterface by lazy {
        Retrofit.Builder()
            .baseUrl("https://quotes21.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
    }
}