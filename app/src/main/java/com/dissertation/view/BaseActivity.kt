package com.dissertation.view

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import com.dissertation.R
import com.dissertation.view.util.ThemeUtil
import com.dissertation.viewmodel.ThemeViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber


abstract class BaseActivity : AppCompatActivity() {

    val themeViewModel: ThemeViewModel by viewModel()
    val themeUtil: ThemeUtil by inject()

    protected abstract fun getLayoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setupViewModel()
        themeUtil.applyTheme(this)
        setContentView(getLayoutId())
    }

    protected fun setAppThemeMode(darkMode: Boolean) {
//        themeViewModel.applyTheme(darkMode)
        themeUtil.applyTheme(this, darkMode)
    }

    private fun setupViewModel() {
        themeViewModel.liveData.observe(this) {
            setTheme(R.style.DissertationAppTheme)
            recreate()
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

        when (newConfig.uiMode and Configuration.UI_MODE_NIGHT_MASK) {
            Configuration.UI_MODE_NIGHT_NO -> Timber.d("On light theme")
            Configuration.UI_MODE_NIGHT_YES -> Timber.d("On dark theme")
        }
    }
}