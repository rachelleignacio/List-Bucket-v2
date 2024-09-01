package com.rachelleignacio.listbucketv2.data

import android.content.Context
import androidx.room.Room
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
@ComponentScan("com.rachelleignacio.listbucketv2.data")
class DataModule {

    @Single
    fun provideListDatabase(applicationContext: Context): ListDatabase =
        Room.databaseBuilder(
            applicationContext,
            ListDatabase::class.java,
            "list-database"
        ).build()

    @Single
    fun provideListDao(db: ListDatabase) = db.listDao()
}