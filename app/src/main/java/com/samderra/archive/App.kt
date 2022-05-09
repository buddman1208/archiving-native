package com.samderra.archive

import android.app.Application
import android.content.Context
import com.samderra.archive.data.apiModule
import com.samderra.archive.data.networkModule
import com.samderra.archive.data.remote.repositoryModule
import com.samderra.archive.data.remoteDataSourceModule
import com.samderra.archive.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.module.Module

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        instance = this
        setKoin()
    }

    private fun setKoin() {
        setupKoin(
            this,
            apiModule,
            networkModule,
            remoteDataSourceModule,
//            localDataSourceModule,
            repositoryModule,
            viewModelModule
        )
    }

    companion object {
        lateinit var instance: Application
    }
}

fun setupKoin(
    context: Context,
    vararg module: Module
) {
    startKoin {
//        logger(if (BuildConfig.DEBUG) AndroidLogger() else EmptyLogger())
        androidContext(context)
        modules(*module)
    }
}
