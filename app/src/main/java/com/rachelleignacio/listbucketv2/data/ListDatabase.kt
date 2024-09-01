package com.rachelleignacio.listbucketv2.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    version = 1,
    entities = [ListEntity::class, ListItemEntity::class]
)
abstract class ListDatabase : RoomDatabase() {
    abstract fun listDao(): ListDao
}