package com.dissertation

import android.os.Bundle
import com.dissertation.view.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun getLayoutId() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        darkThemeButton.setOnClickListener {
            setAppTheme(true)

        }

        lightThemeButton.setOnClickListener {
            setAppTheme(false)

        }
    }
}
