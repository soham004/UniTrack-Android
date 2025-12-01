package com.soham.classplan.model.remote

import retrofit2.http.GET

data class GitHubFileResponse(
    val content: String,
    val encoding: String
)

interface MessMenuApi {

    @GET("repos/soham004/UniTrack-Android-Data/contents/mess_menu.json")
    suspend fun getMessMenuFile(): GitHubFileResponse
}
