package com.soham.classplan.model.remote

import retrofit2.http.GET

interface MessMenuApi {

    @GET("mess_menu.json")
    suspend fun getMessMenu(): MessMenuDTO
}
