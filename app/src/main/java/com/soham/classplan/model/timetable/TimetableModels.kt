package com.soham.classplan.model.timetable

import androidx.compose.ui.graphics.vector.ImageVector
import java.time.LocalTime

data class TimetableSlot(
    val title: String,
    val location: String,
    val start: LocalTime,
    val end: LocalTime
)

data class TimetableDay(
    val label: String,
    val icon: ImageVector,
    val slots: List<TimetableSlot>,
    val note: String? = null
)

