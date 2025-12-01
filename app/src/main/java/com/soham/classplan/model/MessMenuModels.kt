package com.soham.classplan.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Cookie
import androidx.compose.material.icons.outlined.DinnerDining
import androidx.compose.material.icons.outlined.EggAlt
import androidx.compose.material.icons.outlined.LocalCafe
import androidx.compose.material.icons.outlined.LocalDining
import androidx.compose.material.icons.outlined.LunchDining
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