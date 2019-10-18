package com.dissertation.viewmodel

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.edit
import androidx.lifecycle.MutableLiveData

class ThemeViewModel(val sharedPreferences: SharedPreferences) : BaseViewModel() {

    val liveData = MutableLiveData<Boolean>()

    init {
        applyTheme()
    }

    fun applyTheme(darkMode: Boolean = sharedPreferences.getBoolean(DARK_MODE_KEY, false)) {
        setAppThemeMode(darkMode)
    }

    private fun setAppThemeMode(darkMode: Boolean = false) {
        if (darkMode != sharedPreferences.getBoolean(DARK_MODE_KEY, false)) {
            AppCompatDelegate.setDefaultNightMode(if (darkMode) AppCompatDelegate.MODE_NIGHT_YES else AppCompatDelegate.MODE_NIGHT_NO)
            persistTheme(darkMode)
            liveData.value = true
        }
    }

    private fun persistTheme(darkMode: Boolean) {
        sharedPreferences.edit { putBoolean(DARK_MODE_KEY, darkMode) }
    }

    companion object {
        const val DARK_MODE_KEY = "currentThemeKey"
    }

}