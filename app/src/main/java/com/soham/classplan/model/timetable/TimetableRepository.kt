package com.soham.classplan.model.timetable

import android.content.Context
import com.google.gson.Gson
import com.soham.classplan.model.remote.timetable.TimetableDTO
import com.soham.classplan.model.remote.ApiClient
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TimetableRepository(private val context: Context) {

    val timetableFlow: Flow<List<TimetableDay>> = loadTimetableJson(context).map { json ->
        if (json != null)
            Gson().fromJson(json, TimetableDTO::class.java).toDomain()
        else emptyList()
    }

    suspend fun refresh() {
        println("TIMETABLE FETCHING")
        try {
            val dto = ApiClient.timetableApi.getTimetable()
            val json = Gson().toJson(dto)
            saveTimetableJson(context, json)
            println("TIMETABLE FETCHED & SAVED")
        } catch (e: Exception) {
            println("ERROR FETCHING TIME TABLE: ${e.message}")
            e.printStackTrace()
        }
    }
}
