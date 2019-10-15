package com.dissertation.di

import android.content.Context
import androidx.room.Room
import com.dissertation.data.converter.JSONConverter
import com.dissertation.model.product.ProductModel
import com.dissertation.repo.db.AppDatabase
import com.dissertation.repo.db.util.DBConverter
import com.dissertation.repo.product.ProductRepo
import com.dissertation.repo.product.ProductRepoImpl
import com.dissertation.view.util.ThemeUtil
import com.dissertation.viewmodel.SplashViewModel
import com.dissertation.viewmodel.ThemeViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


class AppModule {
    val modules by lazy { listOf(roomModule, mvvmModule, preferenceModule) }

    private val roomModule = module {
        factory { JSONConverter() }
        factory { DBConverter(get()) }

        single {
            Room.databaseBuilder(
                get(),
                AppDatabase::class.java,
                AppDatabase.DATABASE_NAME
            ).build()
        }

        single { get<AppDatabase>().productDao() }
        single { get<AppDatabase>().reviewDao() }
    }

    private val mvvmModule = module {
        factory<ProductRepo> { ProductRepoImpl(get(), get(), get()) }
        factory { ProductModel(get()) }

        viewModel {
            SplashViewModel(get())
        }

        viewModel {
            ThemeViewModel(get())
        }
    }

    private val preferenceModule = module {
        single { androidApplication().getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE) }
        single { ThemeUtil(get()) }
    }

    companion object {
        const val PREFERENCE_NAME = "com.dissertation.preference"
    }
}
