package com.soham.classplan.model

import android.content.Context
import android.util.Base64
import com.google.gson.Gson
import com.soham.classplan.model.local.loadMessMenuJson
import com.soham.classplan.model.local.saveMessMenuJson
import com.soham.classplan.model.mapper.toDomain
import com.soham.classplan.model.remote.MessMenuApiClient
import com.soham.classplan.model.remote.GitHubFileResponse
import com.soham.classplan.model.remote.MessMenuDTO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MessMenuRepository(private val context: Context) {

    // Load from cache (DataStore)
    val messMenuFlow: Flow<List<MessMenuDay>> =
        loadMessMenuJson(context).map { json ->
            if (json != null)
                Gson().fromJson(json, MessMenuDTO::class.java).toDomain()
            else emptyList()
        }

    // Fetch from GitHub API + decode Base64 + save to DataStore
    suspend fun refresh() {
        try {
            // Fetch GitHub API file (Base64 encoded)
            val response: GitHubFileResponse =
                MessMenuApiClient.api.getMessMenuFile()

            // Decode Base64 → String JSON
            val decodedJson = String(
                Base64.decode(response.content, Base64.DEFAULT)
            )

            println("Decoded JSON: $decodedJson")

            // Save into DataStore cache
            saveMessMenuJson(context, decodedJson)

        } catch (e: Exception) {
            println("ERROR FETCHING MESS MENU:")
            e.printStackTrace()
        }
    }
}
