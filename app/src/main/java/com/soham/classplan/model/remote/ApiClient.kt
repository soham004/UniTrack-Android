package com.soham.classplan.model.remote

import com.soham.classplan.model.remote.messmenu.MessMenuApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private const val BASE_URL = "https://raw.githubusercontent.com/soham004/UniTrack-Android-Data/main/"

    val api: MessMenuApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MessMenuApi::class.java)
    }
}
