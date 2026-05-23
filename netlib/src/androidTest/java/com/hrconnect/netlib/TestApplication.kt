package com.hrconnect.netlib

import android.app.Application
import androidx.test.platform.app.InstrumentationRegistry
import com.hrconnect.netlib.di.netLibModule
import logcat.AndroidLogcatLogger
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Класс приложения для инструментальных тестов.
 *
 * Дата создания: 23-05-2026.
 * Автор создания: 1.
 */
class TestApplication : Application() {

    /**
     * Функция для первоначальной настройки тестового приложения.
     */
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(InstrumentationRegistry.getInstrumentation().targetContext.applicationContext)
            modules(netLibModule)
        }
        AndroidLogcatLogger.installOnDebuggableApp(this)
    }
}