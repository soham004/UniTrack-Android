package com.soham.classplan.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Code
import androidx.compose.material.icons.outlined.Computer
import androidx.compose.material.icons.outlined.School
import androidx.compose.material.icons.outlined.Science
import androidx.compose.material.icons.outlined.Settings
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

object TimetableRepository {
    val sampleWeek: List<TimetableDay> by lazy {
        listOf(
            TimetableDay(
                label = "Mon",
                icon = Icons.Outlined.Code,
                slots = listOf(
                    slot("ML", "C25-A-213", 8, 9),
                    slot("AI(L)", "C25-A-204(L)", 9, 11),
                    slot("CC", "C25-A-111", 11, 12),
                    slot("UHV", "C25-A-111", 12, 13)
                ),
                note = "Continuous from 08:00 to 13:00"
            ),
            TimetableDay(
                label = "Tue",
                icon = Icons.Outlined.School,
                slots = listOf(
                    slot("HSE", "----", 9, 10),
                    slot("ML", "C25-B-019", 10, 11),
                    slot("AI", "C25-A-207", 11, 12),
                    slot("CC", "C25-A-207", 12, 13)
                ),
                note = "Continuous from 09:00 to 13:00"
            ),
            TimetableDay(
                label = "Wed",
                icon = Icons.Outlined.Computer,
                slots = listOf(
                    slot("HSE", "----", 10, 11),
                    slot("AD", "C25-A-203(L)", 11, 12),
                    slot("AD(L)", "C25-A-203(L)", 12, 14)
                ),
                note = "Labs from 11:00 onwards"
            ),
            TimetableDay(
                label = "Thu",
                icon = Icons.Outlined.Science,
                slots = listOf(
                    slot("ML", "C25-B-107", 9, 10),
                    slot("AI", "C25-B-107", 10, 11),
                    slot("UHV", "C25-A-111", 11, 12),
                    slot("CC", "C25-A-111", 12, 13)
                ),
                note = "Continuous from 09:00 to 13:00"
            ),
            TimetableDay(
                label = "Fri",
                icon = Icons.Outlined.Settings,
                slots = listOf(
                    slot("HSE", "----", 9, 10),
                    slot("ML", "C25-B-019", 10, 11),
                    slot("UHV", "C25-B-207", 11, 12),
                    slot("AI", "C25-B-207", 12, 13)
                ),
                note = "Continuous from 09:00 to 13:00"
            )
        )
    }

    private fun slot(
        title: String,
        location: String,
        startHour: Int,
        endHour: Int
    ): TimetableSlot = TimetableSlot(
        title = title,
        location = location,
        start = LocalTime.of(startHour, 0),
        end = LocalTime.of(endHour, 0)
    )
}
