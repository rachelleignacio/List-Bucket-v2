package com.rachelleignacio.listbucketv2.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ListDao {
    @Insert
    suspend fun insert(list: ListEntity)

    @Update
    suspend fun update(list: ListEntity)

    @Update
    suspend fun updateAll(lists: List<ListEntity>)

    @Query("SELECT * FROM lists")
    fun getAll(): Flow<List<ListEntity>>

    @Transaction
    @Query("SELECT * FROM lists")
    fun getListWithItems(): Flow<List<ListWithItems>>

    @Delete
    suspend fun delete(list: ListEntity)

    @Insert
    suspend fun insertItem(listItem: ListItemEntity)

    @Delete
    suspend fun deleteItem(listItem: ListItemEntity)
}