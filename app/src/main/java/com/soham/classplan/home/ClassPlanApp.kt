package com.soham.classplan.home

import kotlinx.coroutines.launch
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
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.soham.classplan.classes.ClassesScreen
import com.soham.classplan.mess.MessMenuScreen
import com.soham.classplan.model.messmenu.MessMenuRepository
import com.soham.classplan.model.timetable.TimetableRepository
import com.soham.classplan.shared.currentDayIndex


enum class HomeTab { Classes, Mess }

@Composable
fun ClassPlanApp() {

    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    // --------------------------
    // TIMETABLE (Dynamic Loading)
    // --------------------------
    val classRepo = remember { TimetableRepository(context) }
    val classDays by classRepo.timetableFlow.collectAsState(emptyList())

    var selectedClassDay by remember { mutableIntStateOf(0) }
    var timetableRefreshing by remember { mutableStateOf(false) }

    // Auto-select today's class day when data loads
    LaunchedEffect(classDays) {
        if (classDays.isNotEmpty()) {
            selectedClassDay = currentDayIndex(classDays.map { it.label })
        }
    }

    // MESS MENU (Dynamic Setup Stage)
    val messRepo = remember { MessMenuRepository(context) }
    val messDays by messRepo.messMenuFlow.collectAsState(emptyList())

    var selectedMessDay by remember { mutableIntStateOf(0) }
    var messRefreshing by remember { mutableStateOf(false) }


    // Auto-select today's mess day when loaded
    LaunchedEffect(messDays) {
        if (messDays.isNotEmpty()) {
            selectedMessDay = currentDayIndex(messDays.map { it.label })
        }
    }

    var currentTab by remember { mutableStateOf(HomeTab.Classes) }

    Scaffold(
        bottomBar = { ClassPlanBottomBar(currentTab) { currentTab = it } },
        containerColor = MaterialTheme.colorScheme.background
    ) { paddingValues ->

        when (currentTab) {


            // Classes Tab (Dynamic JSON)

            HomeTab.Classes -> {
                ClassesScreen(
                    modifier = Modifier.padding(paddingValues),
                    days = classDays,
                    selectedIndex = selectedClassDay,
                    onDaySelected = { selectedClassDay = it },
                    isRefreshing = timetableRefreshing,
                    onRefresh = {
                        scope.launch {
                            timetableRefreshing = true
                            classRepo.refresh()
                            timetableRefreshing = false
                        }
                    }
                )
            }

            // Mess Tab
            HomeTab.Mess -> {
                MessMenuScreen(
                    modifier = Modifier.padding(paddingValues),
                    days = messDays,
                    selectedIndex = selectedMessDay,
                    onDaySelected = { selectedMessDay = it },
                    isRefreshing = messRefreshing,
                    onRefresh = {
                        scope.launch {
                            messRefreshing = true
                            messRepo.refresh()
                            messRefreshing = false
                        }
                    }
                )
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
