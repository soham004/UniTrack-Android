package com.soham.classplan.model.remote.messmenu

import retrofit2.http.GET

data class GitHubFileResponse(
    val content: String,
    val encoding: String
)

interface MessMenuApi {

    @GET("mess_menu.json")
    suspend fun getMessMenuFile(): MessMenuDTO
}
