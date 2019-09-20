package com.dissertation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dissertation.data.product.factory.ProductFactory
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Timber.d(ProductFactory().products.size.toString())
    }
}
