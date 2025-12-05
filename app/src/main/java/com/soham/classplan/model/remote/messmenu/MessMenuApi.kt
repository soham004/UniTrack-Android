package com.soham.classplan.model.remote.messmenu

import retrofit2.http.GET


interface MessMenuApi {

    @GET("mess_menu.json")
    suspend fun getMessMenuFile(): MessMenuDTO
}
