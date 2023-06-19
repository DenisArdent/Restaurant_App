package com.denisardent.common

sealed class StatusResult<T>

class PendingStatusResult<T>: StatusResult<T>()

sealed class FinalStatusResult<T>: StatusResult<T>()

class ErrorStatusResult<T>(val exception: Exception): FinalStatusResult<T>()

class SuccessStatusResult<T>(val data: T): FinalStatusResult<T>()