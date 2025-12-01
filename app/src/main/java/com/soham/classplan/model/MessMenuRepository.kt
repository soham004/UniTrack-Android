package com.soham.classplan.model

import android.content.Context
import com.soham.classplan.model.local.loadMessMenuJson
import com.soham.classplan.model.local.saveMessMenuJson
import com.soham.classplan.model.mapper.toDomain
import com.soham.classplan.model.remote.MessMenuApiClient
import com.soham.classplan.model.remote.MessMenuDTO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import com.google.gson.Gson

class MessMenuRepository(private val context: Context) {

    // Load from cache (DataStore)
    val messMenuFlow: Flow<List<MessMenuDay>> =
        loadMessMenuJson(context).map { json ->
            if (json != null)
                Gson().fromJson(json, MessMenuDTO::class.java).toDomain()
            else emptyList()
        }

    // Fetch from GitHub + save into cache
    suspend fun refresh() {
        try {
            val dto = MessMenuApiClient.api.getMessMenu()
            println("DTO received: $dto")   // ADD THIS
            val json = Gson().toJson(dto)
            println("Saving JSON: $json")   // ADD THIS
            saveMessMenuJson(context, json)
        } catch (e: Exception) {
            println("ERROR FETCHING MESS MENU:")
            e.printStackTrace()
        }
    }

}