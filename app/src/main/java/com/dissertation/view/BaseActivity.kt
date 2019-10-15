package com.dissertation.view

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.edit
import com.dissertation.R
import timber.log.Timber

abstract class BaseActivity : AppCompatActivity() {

    protected abstract fun getLayoutId(): Int
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
        setAppTheme(sharedPreferences.getBoolean(DARK_MODE_KEY, false))
        setContentView(getLayoutId())
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

        when (newConfig.uiMode and Configuration.UI_MODE_NIGHT_MASK) {
            Configuration.UI_MODE_NIGHT_NO -> Timber.d("On light theme")
            Configuration.UI_MODE_NIGHT_YES -> Timber.d("On dark theme")
        }
    }

    fun setAppTheme(darkMode: Boolean = false) {
        val resourceId: Int
        if (darkMode) {
            resourceId = R.style.DissertationDarkTheme
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            resourceId = R.style.DissertationLightTheme
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }

        persistTheme(darkMode)
        setTheme(resourceId)
    }

    private fun persistTheme(darkMode: Boolean) {
        if (::sharedPreferences.isInitialized) {
            sharedPreferences.edit { putBoolean(DARK_MODE_KEY, darkMode) }
        }
    }

    companion object {
        const val PREFERENCE_NAME = "dissertation_preference"
        const val DARK_MODE_KEY = "currentThemeKey"
    }
}