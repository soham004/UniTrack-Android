package com.soham.classplan.model.remote

data class DayMealsDTO(
    val breakfast: List<String>,
    val lunch: List<String>,
    val snacks: List<String>,
    val dinner: List<String>
)

data class MessMenuDTO(
    val monday: DayMealsDTO,
    val tuesday: DayMealsDTO,
    val wednesday: DayMealsDTO,
    val thursday: DayMealsDTO,
    val friday: DayMealsDTO,
    val saturday: DayMealsDTO,
    val sunday: DayMealsDTO
)
