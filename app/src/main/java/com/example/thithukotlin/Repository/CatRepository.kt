package com.example.thithukotlin.Repository

import com.example.thithukotlin.Model.Cat
import com.example.thithukotlin.Network.RetrofitInstance

class CatRepository {
    suspend fun getCats(): List<Cat> {
        return RetrofitInstance.api.getCuteCats()
    }
}
