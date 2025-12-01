package com.soham.classplan.shared

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.soham.classplan.ui.theme.TextMuted
import com.soham.classplan.ui.theme.TextPrimary
import com.soham.classplan.ui.theme.TextSecondary
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalTime

@Composable
fun HeaderSection(title: String) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "made by Soham De",
            style = MaterialTheme.typography.labelMedium,
            color = TextMuted
        )
        Text(
            text = title,
            style = MaterialTheme.typography.displaySmall,
            color = TextPrimary,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun <T> WeekdaySelector(
    items: List<T>,
    selectedIndex: Int,
    onDaySelected: (Int) -> Unit,
    label: (T) -> String,
    icon: (T) -> ImageVector
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        items.forEachIndexed { index, item ->
            val isSelected = index == selectedIndex
            val containerColor = if (isSelected) MaterialTheme.colorScheme.primary.copy(alpha = 0.25f) else MaterialTheme.colorScheme.surfaceVariant
            val contentColor = if (isSelected) MaterialTheme.colorScheme.onPrimary else TextSecondary
            val borderColor = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outline

            Card(
                onClick = { onDaySelected(index) },
                modifier = Modifier.weight(1f),
                colors = CardDefaults.cardColors(containerColor = containerColor),
                shape = RoundedCornerShape(18.dp),
                border = BorderStroke(1.dp, borderColor)
            ) {
                Column(
                    modifier = Modifier
                        .padding(vertical = 12.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Icon(
                        imageVector = icon(item),
                        contentDescription = label(item),
                        tint = contentColor,
                        modifier = Modifier.size(20.dp)
                    )
                    Text(
                        text = label(item),
                        style = MaterialTheme.typography.titleMedium,
                        color = contentColor
                    )
                }
            }
        }
    }
}

fun currentDayIndex(labels: List<String>): Int {
    val todayLabel = DayOfWeek.from(LocalDate.now()).shortLabel()
    val index = labels.indexOfFirst { it.equals(todayLabel, ignoreCase = true) }
    return if (index >= 0) index else 0
}

fun String.fullDayName(): String = when (this) {
    "Mon" -> "Monday"
    "Tue" -> "Tuesday"
    "Wed" -> "Wednesday"
    "Thu" -> "Thursday"
    "Fri" -> "Friday"
    "Sat" -> "Saturday"
    "Sun" -> "Sunday"
    else -> this
}

fun LocalTime.formatTime(): String = "%02d:%02d".format(hour, minute)

private fun DayOfWeek.shortLabel(): String = when (this) {
    DayOfWeek.MONDAY -> "Mon"
    DayOfWeek.TUESDAY -> "Tue"
    DayOfWeek.WEDNESDAY -> "Wed"
    DayOfWeek.THURSDAY -> "Thu"
    DayOfWeek.FRIDAY -> "Fri"
    DayOfWeek.SATURDAY -> "Sat"
    DayOfWeek.SUNDAY -> "Sun"
}
