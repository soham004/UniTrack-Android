package com.soham.classplan.classes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.soham.classplan.model.TimetableDay
import com.soham.classplan.model.TimetableSlot

import com.soham.classplan.shared.HeaderSection
import com.soham.classplan.shared.WeekdaySelector
import com.soham.classplan.shared.fullDayName
import com.soham.classplan.shared.formatTime

import com.soham.classplan.ui.theme.TextPrimary
import com.soham.classplan.ui.theme.TextSecondary

@Composable
fun ClassesScreen(
    modifier: Modifier,
    days: List<TimetableDay>,
    selectedIndex: Int,
    onDaySelected: (Int) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
    ) {
        Spacer(Modifier.height(50.dp))
        HeaderSection(title = "Time Table")
        Spacer(Modifier.height(50.dp))
        WeekdaySelector(
            items = days,
            selectedIndex = selectedIndex,
            onDaySelected = onDaySelected,
            label = { it.label },
            icon = { it.icon }
        )
        Spacer(Modifier.height(45.dp))
        DaySchedule(day = days[selectedIndex])
    }
}

@Composable
private fun DaySchedule(day: TimetableDay) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = day.label.fullDayName(),
            style = MaterialTheme.typography.headlineSmall,
            color = TextPrimary
        )
        Spacer(Modifier.height(16.dp))
        day.slots.forEach { slot ->
            TimetableCard(slot)
            Spacer(Modifier.height(12.dp))
        }
        day.note?.let {
            Spacer(Modifier.height(12.dp))
            Text(
                text = it,
                style = MaterialTheme.typography.bodyMedium,
                color = TextSecondary,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Composable
private fun TimetableCard(slot: TimetableSlot) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
        shape = androidx.compose.foundation.shape.RoundedCornerShape(20.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Column(modifier = Modifier.weight(1f)) {
                    // Class Title
                    Text(
                        text = slot.title,
                        style = MaterialTheme.typography.titleMedium.copy(fontSize = 18.sp),
                        color = TextPrimary
                    )
                    Spacer(Modifier.height(10.dp))
                    // Class Room Location
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Outlined.Home,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.alignByBaseline().size(20.dp)
                        )
                        Spacer(Modifier.size(4.dp))
                        Text(
                            text = slot.location,
                            style = MaterialTheme.typography.titleMedium,
                            color = TextSecondary
                        )
                    }
                }
                // Class Time
                Text(
                    text = "${slot.start.formatTime()}-${slot.end.formatTime()}",
                    style = MaterialTheme.typography.titleMedium,
                    color = TextPrimary,
                    textAlign = TextAlign.End
                )
            }
        }
    }
}
