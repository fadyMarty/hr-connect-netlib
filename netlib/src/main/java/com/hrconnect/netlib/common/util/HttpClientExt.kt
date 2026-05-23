package com.hrconnect.netlib.common.util

import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.ensureActive
import logcat.LogPriority.ERROR
import logcat.LogPriority.INFO
import logcat.asLog
import logcat.logcat
import retrofit2.HttpException
import java.io.IOException

/**
 * Утилиты для выполнения сетевых запросов с логированием и обработкой ошибок.
 *
 * Дата создания: 23-05-2026.
 * Автор создания: 1.
 */

/**
 * Функция для безопасного выполнения сетевого запроса с логированием и обработкой ошибок.
 *
 * @param tag тег для логирования.
 * @param message сообщение для логирования.
 * @param execute функция для выполнения.
 *
 * @return [Result.success] при успешном выполнении или [Result.failure] при возникновении ошибки.
 */
suspend fun <T> safeCall(
    tag: String,
    message: String,
    execute: suspend () -> T,
): Result<T> {
    return try {
        logcat(tag, INFO) { "Начало запроса — $message" }
        val response = execute()
        logcat(tag) { "Успешно — $message (ответ: $response)" }
        Result.success(response)
    } catch (e: HttpException) {
        logcat(tag, ERROR) { "Ошибка — $message (код ${e.code()})" }
        Result.failure(e)
    } catch (e: IOException) {
        logcat(tag, ERROR) { "Ошибка — $message (отсутствует соединение с сетью Интернет)" }
        Result.failure(e)
    } catch (e: Exception) {
        currentCoroutineContext().ensureActive()
        logcat(tag, ERROR) { "Ошибка — $message (ошибка: ${e.asLog()})" }
        Result.failure(e)
    }
}

/**
 * Функция для выполнения сетевого запроса с логированием.
 *
 * @param tag тег для логирования.
 * @param message сообщение для логирвания.
 * @param execute функция для выполнения.
 *
 * @return результат выполнения сетевого запроса.
 */
suspend fun <T> logCall(
    tag: String,
    message: String,
    execute: suspend () -> T,
): T {
    try {
        logcat(tag, INFO) { "Начало запроса — $message" }
        val response = execute()
        logcat(tag) { "Успешно — $message (ответ: $response)" }
        return response
    } catch (e: HttpException) {
        logcat(tag, ERROR) { "Ошибка — $message (код ${e.code()})" }
        throw e
    } catch (e: IOException) {
        logcat(tag, ERROR) { "Ошибка — $message (отсутствует соединение с сетью Интернет)" }
        throw e
    } catch (e: Exception) {
        currentCoroutineContext().ensureActive()
        logcat(tag, ERROR) { "Ошибка — $message (ошибка: ${e.asLog()})" }
        throw e
    }
}