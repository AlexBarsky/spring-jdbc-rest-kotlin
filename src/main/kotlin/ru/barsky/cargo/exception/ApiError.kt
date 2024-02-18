package ru.barsky.cargo.exception

data class ApiError(
    val errorCode: String,
    val message: String
)
