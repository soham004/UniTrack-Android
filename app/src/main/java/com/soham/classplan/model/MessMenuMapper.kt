package com.soham.classplan.model.mapper

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Cookie
import androidx.compose.material.icons.outlined.DinnerDining
import androidx.compose.material.icons.outlined.EggAlt
import androidx.compose.material.icons.outlined.LocalCafe
import androidx.compose.material.icons.outlined.LocalDining
import androidx.compose.material.icons.outlined.LunchDining
import com.soham.classplan.model.MealSlot
import com.soham.classplan.model.MessMenuDay
import com.soham.classplan.model.remote.DayMealsDTO
import com.soham.classplan.model.remote.MessMenuDTO

fun DayMealsDTO.toMeals(): List<MealSlot> =
    listOf(
        MealSlot("Breakfast", breakfast.joinToString(", ")),
        MealSlot("Lunch", lunch.joinToString(", ")),
        MealSlot("Snacks", snacks.joinToString(", ")),
        MealSlot("Dinner", dinner.joinToString(", "))
    )

fun MessMenuDTO.toDomain(): List<MessMenuDay> =
    listOf(
        MessMenuDay("Mon", Icons.Outlined.LocalDining, monday.toMeals()),
        MessMenuDay("Tue", Icons.Outlined.LocalCafe, tuesday.toMeals()),
        MessMenuDay("Wed", Icons.Outlined.LunchDining, wednesday.toMeals()),
        MessMenuDay("Thu", Icons.Outlined.EggAlt, thursday.toMeals()),
        MessMenuDay("Fri", Icons.Outlined.Cookie, friday.toMeals()),
        MessMenuDay("Sat", Icons.Outlined.DinnerDining, saturday.toMeals()),
        MessMenuDay("Sun", Icons.Outlined.LocalDining, sunday.toMeals())
    )
