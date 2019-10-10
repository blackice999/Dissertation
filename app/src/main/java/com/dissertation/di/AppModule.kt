package com.dissertation.di

import androidx.room.Room
import com.dissertation.data.converter.JSONConverter
import com.dissertation.model.product.ProductModel
import com.dissertation.repo.db.AppDatabase
import com.dissertation.repo.db.util.DBConverter
import com.dissertation.repo.product.ProductRepo
import com.dissertation.repo.product.ProductRepoImpl
import com.dissertation.viewmodel.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


class AppModule {
    val modules by lazy { listOf(roomModule, mvvmModule) }

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
    }
}
