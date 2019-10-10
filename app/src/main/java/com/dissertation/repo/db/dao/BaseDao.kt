package com.dissertation.repo.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update

@Dao
interface BaseDao<T> {

    @Insert
    suspend fun insert(t: T): Long

    @Delete
    suspend fun delete(t: T)

    @Update
    suspend fun update(t: T)

    @Insert
    suspend fun insert(t: Iterable<T>)
}