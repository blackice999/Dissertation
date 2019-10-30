package com.dissertation.view.main

import android.os.Bundle
import com.dissertation.R
import com.dissertation.view.BaseActivity
import com.dissertation.view.bottomnav.BottomNavigationDrawerFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun getLayoutId() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bottomAppBar.replaceMenu(R.menu.bottom_appbar)

//        bottomAppBar.setOnMenuItemClickListener { item ->
//            when (item?.itemId) {
//                android.R.id.home -> {
//                    val bottomSheetDrawerFragment = BottomNavigationDrawerFragment()
//                    bottomSheetDrawerFragment.show(
//                        supportFragmentManager,
//                        BottomNavigationDrawerFragment.TAG
//                    )
//
//                    true
//                }
//                else -> false
//            }
//        }

        bottomAppBar.setNavigationOnClickListener {
            val bottomSheetDrawerFragment = BottomNavigationDrawerFragment()
            bottomSheetDrawerFragment.show(
                supportFragmentManager,
                BottomNavigationDrawerFragment.TAG
            )
        }

        darkThemeButton.setOnClickListener {
            setAppThemeMode(true)
        }

        lightThemeButton.setOnClickListener {
            setAppThemeMode(false)
        }
    }
}
