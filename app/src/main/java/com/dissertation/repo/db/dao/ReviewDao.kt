package com.dissertation.repo.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.dissertation.repo.db.entities.ReviewEntity

@Dao
interface ReviewDao : BaseDao<ReviewEntity> {

    @Query("SELECT * FROM review WHERE productId = :productId")
    suspend fun getReviewsForProduct(productId: Int): List<ReviewEntity>
}