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

object MessMenuRepository_ {
    val week: List<MessMenuDay> by lazy {
        listOf(
            MessMenuDay(
                label = "Mon",
                icon = Icons.Outlined.LocalDining,
                meals = defaultMeals(
                    breakfast = listOf("Chole Bhatura", "Bread Butter", "Jam", "Kima Onion", "Tea"),
                    lunch = listOf("Lemon Rice", "Roti", "Dal", "Mix Veg with Corn", "French Fries", "Mix Boiled Veg"),
                    snacks = listOf("Badapav", "Tea"),
                    dinner = listOf(
                        "Rice",
                        "Roti",
                        "Mix Dal Tadka",
                        "Aloo Jeera Capsicum (Dry)",
                        "Rasgulla (1 pc big)",
                        "Mix Boiled Veg"
                    )
                )
            ),
            MessMenuDay(
                label = "Tue",
                icon = Icons.Outlined.LocalCafe,
                meals = defaultMeals(
                    breakfast = listOf(
                        "Daal Bada",
                        "Aloo Dum",
                        "Vada Ghugni with Chutney",
                        "Cornflakes",
                        "Milk",
                        "Banana",
                        "Tea"
                    ),
                    lunch = listOf(
                        "Kofta",
                        "Egg Kalia",
                        "Potato Finger Chips",
                        "Dal Sabji",
                        "Paneer Masala",
                        "Rice",
                        "Mix Dal",
                        "Salad"
                    ),
                    snacks = listOf("Piyaj Pakodi", "Tea"),
                    dinner = listOf(
                        "Rice",
                        "Roti",
                        "Dal",
                        "Chhole Masala",
                        "Aloo Bhujia",
                        "Jalebi (2 pcs)",
                        "Mix Boiled Veg"
                    )
                )
            ),
            MessMenuDay(
                label = "Wed",
                icon = Icons.Outlined.LunchDining,
                meals = defaultMeals(
                    breakfast = listOf(
                        "Veg Chowmein",
                        "Egg Chowmein",
                        "Tomato Sauce",
                        "Chilli Sauce",
                        "Tea"
                    ),
                    lunch = listOf(
                        "Rice",
                        "Roti",
                        "Dal",
                        "Fish Besar",
                        "Matar Paneer",
                        "Salad",
                        "Sriram Papad",
                        "Mix Boiled Veg"
                    ),
                    snacks = listOf("Sweetcorn", "Tea"),
                    dinner = listOf(
                        "Fried Rice",
                        "Roti",
                        "Dal Fry",
                        "Paneer Bhurji",
                        "Chicken Hyderabadi",
                        "Ice Cream/Kulfi (1 pc)",
                        "Mix Boiled Veg"
                    )
                )
            ),
            MessMenuDay(
                label = "Thu",
                icon = Icons.Outlined.EggAlt,
                meals = defaultMeals(
                    breakfast = listOf(
                        "Idli",
                        "Sambar",
                        "Chutney",
                        "Cornflakes",
                        "Milk",
                        "Banana",
                        "Pickle",
                        "Coffee"
                    ),
                    lunch = listOf(
                        "Rice",
                        "Roti",
                        "Dal",
                        "Rajma Masala",
                        "Mix Bhaji/ Dahi Salad",
                        "Mix Boiled Veg"
                    ),
                    snacks = listOf("Papmudi Chaat", "Chutney", "Tea"),
                    dinner = listOf(
                        "Plain Rice",
                        "Roti",
                        "Dal Makhani",
                        "Aloo Gobi Matter (Dry)",
                        "Gulab Jamun (1 big size pc)",
                        "Mix Boiled Veg"
                    )
                )
            ),
            MessMenuDay(
                label = "Fri",
                icon = Icons.Outlined.Cookie,
                meals = defaultMeals(
                    breakfast = listOf("Bread", "Butter", "Jam", "Omelet", "Veg Cutlet", "Tea", "Chilly Sauce"),
                    lunch = listOf(
                        "Roti",
                        "Rice",
                        "Dal",
                        "Paneer Hyderabadi",
                        "Fish Masala",
                        "Potato Karela Chips",
                        "Salad",
                        "Mix Boiled Veg"
                    ),
                    snacks = listOf("Biscuit", "Coffee"),
                    dinner = listOf("Chicken Biryani", "Veg Biryani", "Paneer Butter Masala", "Raita", "Jaljeera Water")
                )
            ),
            MessMenuDay(
                label = "Sat",
                icon = Icons.Outlined.DinnerDining,
                meals = defaultMeals(
                    breakfast = listOf(
                        "Poha with Matar",
                        "Sev Bhujia Onion",
                        "Ghugni",
                        "Lemon",
                        "Cornflakes",
                        "Milk",
                        "Banana",
                        "Tea"
                    ),
                    lunch = listOf(
                        "Rice",
                        "Roti",
                        "Dalma",
                        "Veg Manchurian",
                        "Aloo Chokha",
                        "Sriram Papad",
                        "Mix Khichdi"
                    ),
                    snacks = listOf("Maggi", "Tea"),
                    dinner = listOf(
                        "Rice",
                        "Roti",
                        "Dal",
                        "Chicken Mughlai",
                        "Palak Paneer",
                        "Gajar Halwa",
                        "Mix Boiled Veg"
                    )
                )
            ),
            MessMenuDay(
                label = "Sun",
                icon = Icons.Outlined.LocalDining,
                meals = defaultMeals(
                    breakfast = listOf("Dosa", "Sambar", "Chutney", "Bread Butter", "Jam", "Coffee"),
                    lunch = listOf(
                        "Roti",
                        "Rice",
                        "Dal",
                        "Egg Masala",
                        "Aloo Besan/ Soyabin Masala",
                        "Mix Boiled Veg",
                        "Aloo Chips/ Dahi Salad"
                    ),
                    snacks = listOf("Pasta", "Tea"),
                    dinner = listOf(
                        "Zeera Rice",
                        "Roti",
                        "Dal",
                        "Kadhai Paneer",
                        "Chicken Kasa",
                        "Malpua",
                        "Mix Boiled Veg"
                    )
                )
            )
        )
    }

    private fun defaultMeals(
        breakfast: List<String>,
        lunch: List<String>,
        snacks: List<String>,
        dinner: List<String>
    ) = listOf(
        MealSlot("Breakfast", breakfast.joinToString(", ")),
        MealSlot("Lunch", lunch.joinToString(", ")),
        MealSlot("Snacks", snacks.joinToString(", ")),
        MealSlot("Dinner", dinner.joinToString(", "))
    )
}
