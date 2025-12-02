package com.soham.classplan.model.messmenu

import androidx.compose.ui.graphics.vector.ImageVector

data class MealSlot(
    val title: String,
    val description: String
)

data class MessMenuDay(
    val label: String,
    val icon: ImageVector,
    val meals: List<MealSlot>
)