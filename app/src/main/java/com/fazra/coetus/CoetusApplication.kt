package com.fazra.coetus

import android.app.Application
import com.fazra.coetus.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class CoetusApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@CoetusApplication)
            modules(
                appModule
            )
        }
    }
}