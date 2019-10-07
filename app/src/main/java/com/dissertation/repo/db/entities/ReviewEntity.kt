package com.dissertation.repo.db.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "review",
    indices = [Index("productId")],
    foreignKeys = [ForeignKey(
        entity = ProductEntity::class,
        parentColumns = ["id"],
        childColumns = ["productId"],
        onDelete = CASCADE
    )]
)
data class ReviewEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int?,
    var productId: Long,
    var comment: String,
    var rating: Int
) {
    constructor() : this(null, 0, "", 0)
}