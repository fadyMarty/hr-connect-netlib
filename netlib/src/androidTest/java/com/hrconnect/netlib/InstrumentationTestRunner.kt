package com.hrconnect.netlib

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner

/**
 * Тестовый раннер для инструментальных тестов.
 *
 * Дата создания: 26-05-2026.
 * Автор создания: 1.
 */
class InstrumentationTestRunner : AndroidJUnitRunner() {

    /**
     * Функция для создания экземпляра класса приложения для инструментальных тестов.
     *
     * @param classLoader загрузчик классов приложения.
     * @param className имя класса приложения.
     * @param context контекст приложения.
     *
     * @return экземпляр класса приложения.
     */
    override fun newApplication(
        classLoader: ClassLoader?,
        className: String?,
        context: Context?,
    ): Application {
        return super.newApplication(classLoader, TestApplication::class.java.name, context)
    }
}