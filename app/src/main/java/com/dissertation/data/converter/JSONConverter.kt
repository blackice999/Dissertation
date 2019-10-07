package com.dissertation.data.converter

import com.squareup.moshi.Moshi

class JSONConverter {
    val moshi: Moshi = Moshi.Builder().build()

    inline fun <reified T> toJsonString(t: T): String {
        return moshi.adapter(T::class.java).toJson(t)
    }

    inline fun <reified T> fromJsonString(jsonString: String): T? {
        return moshi.adapter(T::class.java).fromJson(jsonString)
    }
}