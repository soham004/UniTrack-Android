package com.soham.classplan.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.soham.classplan.classes.ClassesScreen
import com.soham.classplan.mess.MessMenuScreen
import com.soham.classplan.model.MessMenuRepository
import com.soham.classplan.model.TimetableRepository
import com.soham.classplan.shared.currentDayIndex

enum class HomeTab { Classes, Mess }

@Composable
fun ClassPlanApp() {

    // ----------------------
    // CLASS DAYS (unchanged)
    // ----------------------
    val classDays = TimetableRepository.sampleWeek
    val defaultClassDay = remember(classDays) {
        currentDayIndex(classDays.map { it.label })
    }
    var selectedClassDay by remember { mutableIntStateOf(defaultClassDay) }

    // ----------------------
    // MESS DAYS (Dynamic JSON)
    // ----------------------
    val context = LocalContext.current
    val repo = remember { MessMenuRepository(context) }
    val messDays by repo.messMenuFlow.collectAsState(emptyList())

    // Try to load on startup
    LaunchedEffect(Unit) {
        repo.refresh()
    }

    // Avoid crash when messDays is empty
    val defaultMessDay = remember(messDays) {
        if (messDays.isNotEmpty())
            currentDayIndex(messDays.map { it.label })
        else 0
    }

    var selectedMessDay by remember { mutableIntStateOf(defaultMessDay) }

    var currentTab by remember { mutableStateOf(HomeTab.Classes) }

    Scaffold(
        bottomBar = { ClassPlanBottomBar(currentTab) { currentTab = it } },
        containerColor = MaterialTheme.colorScheme.background
    ) { paddingValues ->

        when (currentTab) {

            HomeTab.Classes -> {
                ClassesScreen(
                    modifier = Modifier.padding(paddingValues),
                    days = classDays,
                    selectedIndex = selectedClassDay,
                    onDaySelected = { selectedClassDay = it }
                )
            }

            HomeTab.Mess -> {
                if (messDays.isEmpty()) {
                    // Loading UI
                    Box(
                        modifier = Modifier
                            .padding(paddingValues)
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Loading mess menu…")
                    }
                } else {
                    MessMenuScreen(
                        modifier = Modifier.padding(paddingValues),
                        days = messDays,
                        selectedIndex = selectedMessDay,
                        onDaySelected = { selectedMessDay = it }
                    )
                }
            }
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
