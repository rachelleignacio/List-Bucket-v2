package com.rachelleignacio.listbucketv2.data

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "lists")
data class ListEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    val name: String,
    val order: Int
)

data class ListWithItems(
    @Embedded val list: ListEntity,
    @Relation(parentColumn = "id", entityColumn = "parent_column_id") val items: List<ListEntity>
)