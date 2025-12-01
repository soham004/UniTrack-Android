package com.soham.classplan.model.local

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.messMenuDataStore by preferencesDataStore("mess_menu_cache")

object MessMenuKeys {
    val JSON = stringPreferencesKey("mess_json")
}

suspend fun saveMessMenuJson(context: Context, json: String) {
    context.messMenuDataStore.edit { it[MessMenuKeys.JSON] = json }
}

fun loadMessMenuJson(context: Context): Flow<String?> =
    context.messMenuDataStore.data.map { it[MessMenuKeys.JSON] }
