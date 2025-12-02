package com.soham.classplan.model.remote.timetable

data class TimetableDTO(
    val days: List<TimetableDayDTO>
)

data class TimetableDayDTO(
    val label: String,
    val slots: List<TimetableSlotDTO>,
    val note: String?
)

data class TimetableSlotDTO(
    val title: String,
    val location: String,
    val start: String,
    val end: String
)
