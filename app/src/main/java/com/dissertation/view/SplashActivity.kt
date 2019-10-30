package com.dissertation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import com.dissertation.R
import com.dissertation.view.main.MainActivity
import com.dissertation.viewmodel.SplashViewModel
import kotlinx.android.synthetic.main.activity_splash.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashActivity : AppCompatActivity() {

    val splashViewModel: SplashViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        setupViewModel()
    }

    private fun setupViewModel() {
        splashViewModel.progressLiveData.observe(this) { progress ->
            if (progress.show) showLoadingView() else hideLoadingView(progress.message)
        }
    }

    private fun showLoadingView() = progressBar.show()

    private fun hideLoadingView(message: String) {
        toast(message)
        startActivity<MainActivity>()
        finish()
        progressBar.hide()
    }
}
