package com.soham.classplan.model.timetable

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Code
import androidx.compose.material.icons.outlined.Computer
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.School
import androidx.compose.material.icons.outlined.Science
import androidx.compose.material.icons.outlined.Settings

import com.soham.classplan.model.remote.timetable.*
import java.time.LocalTime

fun TimetableDTO.toDomain(): List<TimetableDay> =
    days.map { dto ->
        TimetableDay(
            label = dto.label,
            icon = TimetableIcons.iconFor(dto.label),
            slots = dto.slots.map { s ->
                TimetableSlot(
                    title = s.title,
                    location = s.location,
                    start = LocalTime.parse(s.start),
                    end = LocalTime.parse(s.end)
                )
            },
            note = dto.note
        )
    }

object TimetableIcons {
    fun iconFor(label: String) = when (label) {
        "Mon" -> Icons.Outlined.Code
        "Tue" -> Icons.Outlined.School
        "Wed" -> Icons.Outlined.Computer
        "Thu" -> Icons.Outlined.Science
        "Fri" -> Icons.Outlined.Settings
        else -> Icons.Outlined.Home
    }
}
