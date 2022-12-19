package com.example.Retrofit

import com.example.data.Countries
import retrofit2.Call
import retrofit2.http.GET

interface RetroServiceInterface {

    @GET("all")
    fun getListOfData():Call<List<Countries>>
}