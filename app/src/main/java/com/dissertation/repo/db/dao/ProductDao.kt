package com.dissertation.repo.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.dissertation.repo.db.entities.ProductEntity

@Dao
interface ProductDao : BaseDao<ProductEntity> {

    @Query("SELECT * FROM Product")
    suspend fun getProducts(): List<ProductEntity>

    @Query("SELECT COUNT(*) FROM Product")
    suspend fun count(): Int
}