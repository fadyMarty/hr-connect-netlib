package com.hrconnect.netlib

import android.app.Application
import androidx.test.platform.app.InstrumentationRegistry
import com.hrconnect.netlib.di.testNetLibModule
import logcat.AndroidLogcatLogger
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TestApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(InstrumentationRegistry.getInstrumentation().targetContext.applicationContext)
            modules(testNetLibModule)
        }
        AndroidLogcatLogger.installOnDebuggableApp(this)
    }
}