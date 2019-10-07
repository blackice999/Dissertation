package com.dissertation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import com.dissertation.viewmodel.SplashViewModel
import kotlinx.android.synthetic.main.activity_splash.*
import org.jetbrains.anko.startActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashActivity : AppCompatActivity() {

    val splashViewModel: SplashViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        setupViewModel()
    }

    private fun setupViewModel() {
        splashViewModel.loadingLiveData.observe(this) { shouldShow ->
            if (shouldShow.isLoading) showLoadingView() else hideLoadingView()
        }
    }

    private fun showLoadingView() = progressBar.show()

    private fun hideLoadingView() {
        startActivity<MainActivity>()
        finish()
        progressBar.hide()
    }
}
