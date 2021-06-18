package com.picpay.desafio.android.network.model

sealed class ResultError {
    object UnknownError : ResultError()
}