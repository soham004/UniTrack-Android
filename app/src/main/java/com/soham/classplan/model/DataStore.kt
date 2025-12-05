package com.soham.classplan.model

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore

val Context.timetableDataStore by preferencesDataStore("timetable_cache")
val Context.messMenuDataStore by preferencesDataStore("mess_menu_cache")
