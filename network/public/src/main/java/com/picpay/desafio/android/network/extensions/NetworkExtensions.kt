package com.picpay.desafio.android.network.extensions

import com.picpay.desafio.android.network.model.Result
import com.picpay.desafio.android.network.model.ResultError
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun <T> safeCall(
    dispatcher: CoroutineDispatcher = Dispatchers.IO,
    block: suspend () -> T,
): Result<T, ResultError> =
    withContext(dispatcher) {
        try {
            Result.Success(block())
        } catch (e: Exception) {
            Result.Error(ResultError.UnknownError)
        }
    }