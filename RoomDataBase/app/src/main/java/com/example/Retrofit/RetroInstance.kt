package com.example.Retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroInstance {

    companion object {
        /**
         * Fake API Response
         * https://restcountries.com/#api-endpoints-v3-all
         * @Get all Conuntries :- https://restcountries.com/v2/all
         */
        val BASE_URL = "https://restcountries.com/v2/"
        fun getRetroInstance():Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}