package com.dissertation.repo.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dissertation.repo.db.dao.ProductDao
import com.dissertation.repo.db.dao.ReviewDao
import com.dissertation.repo.db.entities.ProductEntity
import com.dissertation.repo.db.entities.ReviewEntity

@Database(entities = [ProductEntity::class, ReviewEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun productDao(): ProductDao
    abstract fun reviewDao(): ReviewDao

    companion object {
        const val DATABASE_NAME = "dissertation"
    }
}