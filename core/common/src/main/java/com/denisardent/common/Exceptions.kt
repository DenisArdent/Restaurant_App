package com.denisardent.common

open class AppException(
    message: String = "",
    cause: Throwable? = null,
) : Exception(message, cause)

class ConnectionException(cause: Exception) : AppException(cause = cause)