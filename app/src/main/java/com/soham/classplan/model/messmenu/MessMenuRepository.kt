package com.soham.classplan.model.messmenu

import android.content.Context
import com.google.gson.Gson
import com.soham.classplan.model.remote.ApiClient
import com.soham.classplan.model.remote.messmenu.MessMenuDTO
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

    suspend fun refresh() {
        println("TIMETABLE FETCHING")
        try {
            val dto = ApiClient.api.getMessMenuFile()
            val json = Gson().toJson(dto)

            saveMessMenuJson(context, json)
            println("MESS MENU FETCHED & SAVED")
        } catch (e: Exception) {
            println("ERROR FETCHING MESS MENU: ${e.message}")
            e.printStackTrace()
        }
    }
}
