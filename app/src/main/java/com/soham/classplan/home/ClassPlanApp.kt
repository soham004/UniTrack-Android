package com.soham.classplan.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Restaurant
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.soham.classplan.classes.ClassesScreen
import com.soham.classplan.mess.MessMenuScreen
import com.soham.classplan.model.MessMenuRepository
import com.soham.classplan.model.TimetableRepository
import com.soham.classplan.shared.currentDayIndex

enum class HomeTab { Classes, Mess }

@Composable
fun ClassPlanApp() {
    val classDays = TimetableRepository.sampleWeek
    val messDays = MessMenuRepository.week

    val defaultClassDay = remember(classDays) { currentDayIndex(classDays.map { it.label }) }
    val defaultMessDay = remember(messDays) { currentDayIndex(messDays.map { it.label }) }

    var selectedClassDay by remember { mutableIntStateOf(defaultClassDay) }
    var selectedMessDay by remember { mutableIntStateOf(defaultMessDay) }
    var currentTab by remember { mutableStateOf(HomeTab.Classes) }

    Scaffold(
        bottomBar = { ClassPlanBottomBar(currentTab) { currentTab = it } },
        containerColor = MaterialTheme.colorScheme.background
    ) { paddingValues ->
        when (currentTab) {
            HomeTab.Classes -> ClassesScreen(
                modifier = Modifier.padding(paddingValues),
                days = classDays,
                selectedIndex = selectedClassDay,
                onDaySelected = { selectedClassDay = it }
            )
            HomeTab.Mess -> MessMenuScreen(
                modifier = Modifier.padding(paddingValues),
                days = messDays,
                selectedIndex = selectedMessDay,
                onDaySelected = { selectedMessDay = it }
            )
        }
    }
}

@Composable
private fun ClassPlanBottomBar(currentTab: HomeTab, onTabSelected: (HomeTab) -> Unit) {
    NavigationBar(
        containerColor = Color.Transparent,
        tonalElevation = 0.dp
    ) {
        NavigationBarItem(
            selected = currentTab == HomeTab.Classes,
            onClick = { onTabSelected(HomeTab.Classes) },
            icon = { Icon(imageVector = Icons.Outlined.Home, contentDescription = "Classes") },
            label = { Text("Classes") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = MaterialTheme.colorScheme.primary,
                selectedTextColor = MaterialTheme.colorScheme.primary,
                indicatorColor = Color.Transparent
            )
        )
        NavigationBarItem(
            selected = currentTab == HomeTab.Mess,
            onClick = { onTabSelected(HomeTab.Mess) },
            icon = { Icon(imageVector = Icons.Outlined.Restaurant, contentDescription = "Mess") },
            label = { Text("Mess") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = MaterialTheme.colorScheme.primary,
                selectedTextColor = MaterialTheme.colorScheme.primary,
                indicatorColor = Color.Transparent
            )
        )
    }
}
