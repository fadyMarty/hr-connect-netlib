package com.hrconnect.netlib.common.util

import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.ensureActive
import logcat.LogPriority.ERROR
import logcat.LogPriority.INFO
import logcat.asLog
import logcat.logcat
import retrofit2.HttpException
import java.io.IOException

suspend fun <T> safeCall(
    tag: String,
    message: String,
    execute: suspend () -> T,
): Result<T> {
    return try {
        logcat(tag, INFO) { "Начало операции — $message" }
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