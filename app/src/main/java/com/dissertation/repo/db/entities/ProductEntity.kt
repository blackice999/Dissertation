package com.dissertation.repo.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product")
data class ProductEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int?,

    @ColumnInfo(name = "category_id")
    var categoryId: String,

    var brand: String,
    var price: Double,
    var quantity: Int,
    var specs: String
) {
    constructor() : this(null, "", "", 0.0, 0, "")
}
