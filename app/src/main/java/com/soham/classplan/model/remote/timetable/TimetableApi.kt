package com.soham.classplan.model.remote.timetable

import retrofit2.http.GET
import retrofit2.http.Query

interface TimetableApi {

    @GET("timetable.json")
    suspend fun getTimetable(
        @Query("t") t: Long = System.currentTimeMillis()   // cache buster
    ): TimetableDTO
}
