package com.hrconnect.network

import android.app.Application
import com.hrconnect.netlib.di.netLibModule
import logcat.AndroidLogcatLogger
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class NetworkApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@NetworkApp)
            modules(netLibModule)
        }
        AndroidLogcatLogger.installOnDebuggableApp(this)
    }
}