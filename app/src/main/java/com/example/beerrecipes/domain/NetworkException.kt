package com.example.beerrecipes.domain

sealed class NetworkException(error: Throwable) : RuntimeException(error) {
    data class NoNetworkException(val error: Throwable) : NetworkException(error)
    data class ServerUnreachableException(val error: Throwable) : NetworkException(error)
    data class HttpCallFailureException(val error: Throwable) : NetworkException(error)
}