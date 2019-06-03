package com.esseckers.test.app.offlinefaketwiterclient

import android.app.Application
import com.esseckers.test.app.offlinefaketwiterclient.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

/**
 * Created by Ivan Danilov.
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            //inject Android context
            androidContext(this@App)
            androidLogger(Level.DEBUG)
            // use modules
            modules(appModule, databaseModule, repositoryModule, interactorModule, presenterModule)
        }
    }
}