package com.soham.classplan.mess

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.soham.classplan.model.MessMenuDay
import com.soham.classplan.model.MealSlot
import com.soham.classplan.shared.HeaderSection
import com.soham.classplan.shared.WeekdaySelector
import com.soham.classplan.shared.fullDayName
import com.soham.classplan.ui.theme.TextPrimary
import com.soham.classplan.ui.theme.TextSecondary

@Composable
fun MessMenuScreen(
    modifier: Modifier,
    days: List<MessMenuDay>,
    selectedIndex: Int,
    onDaySelected: (Int) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
    ) {
        Spacer(Modifier.height(50.dp))
        HeaderSection(title = "Mess Menu")
        Spacer(Modifier.height(50.dp))
        WeekdaySelector(
            items = days,
            selectedIndex = selectedIndex,
            onDaySelected = onDaySelected,
            label = { it.label },
            icon = { it.icon }
        )
        Spacer(Modifier.height(45.dp))
        MessMealsList(day = days[selectedIndex])
    }
}

@Composable
private fun MessMealsList(day: MessMenuDay) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = day.label.fullDayName(),
            style = MaterialTheme.typography.headlineSmall,
            color = TextPrimary
        )
        Spacer(Modifier.height(16.dp))
        day.meals.forEach { meal ->
            MessMealCard(meal)
            Spacer(Modifier.height(12.dp))
        }
    }
}

@Composable
private fun MessMealCard(meal: MealSlot) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
        shape = RoundedCornerShape(20.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 18.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = meal.title,
                style = MaterialTheme.typography.titleMedium.copy(fontSize = 18.sp),
                color = TextPrimary,
                modifier = Modifier.widthIn(min = 72.dp)
            )
            Text(
                text = meal.description,
                style = MaterialTheme.typography.titleMedium,
                color = TextSecondary,
                modifier = Modifier.weight(1f)
            )
        }
    }
}
