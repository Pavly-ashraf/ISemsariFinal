package com.example.isemsari.repository

sealed class Result<T>(
    val data: T? = null,
    val errorMessage: String? = null
) {
    class Success<T>(data: T?) : Result<T>(data)
    class Error<T>(errorMessage: String?) : Result<T>(errorMessage = errorMessage)
    class Loading<T> : Result<T>()
}
