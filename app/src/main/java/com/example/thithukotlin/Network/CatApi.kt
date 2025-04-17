package com.example.thithukotlin.Network

import com.example.thithukotlin.Model.Cat
import retrofit2.http.GET

interface CatApi {
    @GET("cats?tags=cute&skip=0&limit=10")
    suspend fun getCuteCats(): List<Cat>
}
