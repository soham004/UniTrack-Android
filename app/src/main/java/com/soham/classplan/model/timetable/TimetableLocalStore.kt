package com.soham.classplan.model.timetable

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

// Create a dedicated DataStore for timetable
val Context.timetableDataStore by preferencesDataStore("timetable_cache")

private val TIMETABLE_KEY = stringPreferencesKey("timetable_json")

// Save JSON
suspend fun saveTimetableJson(context: Context, value: String) {
    context.timetableDataStore.edit { prefs ->
        prefs[TIMETABLE_KEY] = value
    }
}

// Load JSON as Flow<String?>
fun loadTimetableJson(context: Context): Flow<String?> =
    context.timetableDataStore.data.map { prefs ->
        prefs[TIMETABLE_KEY]
    }
