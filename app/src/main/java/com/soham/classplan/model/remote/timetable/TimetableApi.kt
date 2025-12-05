package com.soham.classplan.model.remote.timetable

import retrofit2.http.GET
import retrofit2.http.Query

interface TimetableApi {

    @GET("time_table.json")
    suspend fun getTimetable(): TimetableDTO
}
