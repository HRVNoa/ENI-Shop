package com.eniecole.eni_shop

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

object DataStoreManager {

    private val Context.dataStore by preferencesDataStore("user_settings")

    private val DARK_THEME = booleanPreferencesKey("DARK_THEME")

    suspend fun setDarkTheme(context: Context, value: Boolean){
        context.dataStore.edit { pref ->
            pref[DARK_THEME] = value
        }
    }

    suspend fun isDarkTheme(context: Context): Flow<Boolean> {
        return context.dataStore.data.map { pref->
            pref[DARK_THEME] ?: false
        }
    }
}