package com.dissertation.model.product

import com.squareup.moshi.Json

enum class ProductCategories {
    @Json(name = "TV")
    TV,
    @Json(name = "TELEPHONE")
    TELEPHONE,
    @Json(name = "WASHING_MACHINE")
    WASHING_MACHINE,
    @Json(name = "INVAID")
    INVALID
}