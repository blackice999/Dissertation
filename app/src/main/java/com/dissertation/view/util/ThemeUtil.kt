package com.dissertation.view.util

import android.app.Activity
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.app.ActivityCompat.recreate
import androidx.core.content.edit
import com.dissertation.R

class ThemeUtil(val sharedPreferences: SharedPreferences) {

    fun applyTheme(
        activity: Activity,
        darkMode: Boolean = sharedPreferences.getBoolean(DARK_MODE_KEY, false)
    ) {
        setAppThemeMode(activity, darkMode)
    }

    private fun setAppThemeMode(activity: Activity, darkMode: Boolean = false) {
        if (darkMode != sharedPreferences.getBoolean(DARK_MODE_KEY, false)) {
            recreate(activity)
            AppCompatDelegate.setDefaultNightMode(if (darkMode) AppCompatDelegate.MODE_NIGHT_YES else AppCompatDelegate.MODE_NIGHT_NO)
            persistTheme(darkMode)
            activity.setTheme(R.style.DissertationLightTheme)
        }
    }

    private fun persistTheme(darkMode: Boolean) {
        sharedPreferences.edit { putBoolean(DARK_MODE_KEY, darkMode) }
    }

    companion object {
        const val DARK_MODE_KEY = "currentThemeKey"
    }
}