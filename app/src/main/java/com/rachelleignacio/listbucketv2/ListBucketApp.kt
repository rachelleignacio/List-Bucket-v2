package com.rachelleignacio.listbucketv2

import android.app.Application
import com.rachelleignacio.listbucketv2.data.DataModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.ksp.generated.module

class ListBucketApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@ListBucketApp)
            modules(DataModule().module)
        }
    }
}