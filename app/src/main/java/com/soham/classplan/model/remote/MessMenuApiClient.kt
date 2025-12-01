package com.soham.classplan.model.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MessMenuApiClient {

    private const val BASE_URL = "https://api.github.com/"

    val api: MessMenuApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MessMenuApi::class.java)
    }
}
