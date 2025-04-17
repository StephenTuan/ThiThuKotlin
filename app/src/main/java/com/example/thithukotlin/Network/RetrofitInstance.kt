package com.example.thithukotlin.Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api: CatApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://cataas.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CatApi::class.java)
    }
}
