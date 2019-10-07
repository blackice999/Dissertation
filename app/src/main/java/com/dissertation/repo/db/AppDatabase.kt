package com.dissertation.repo.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dissertation.data.factory.product.ProductFactory
import com.dissertation.repo.db.dao.ProductDao
import com.dissertation.repo.db.dao.ReviewDao
import com.dissertation.repo.db.entities.ProductEntity
import com.dissertation.repo.db.entities.ReviewEntity
import com.dissertation.repo.db.util.DBConverter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Database(entities = [ProductEntity::class, ReviewEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun productDao(): ProductDao
    abstract fun reviewDao(): ReviewDao

    suspend fun prepopulateDB(dbConverter: DBConverter) = withContext(Dispatchers.Default) {
        if (productDao().count() == 0) {
            ProductFactory().products.forEach { element ->
                val productId = productDao().insert(dbConverter.convertProductToDBEntity(element))

                element.reviews.forEach { reviewElement ->
                    reviewDao().insert(
                        dbConverter.convertReviewToDBEntity(
                            reviewElement,
                            productId
                        )
                    )
                }
            }
        }

        true
    }

    companion object {
        const val DATABASE_NAME = "dissertation"
    }
}