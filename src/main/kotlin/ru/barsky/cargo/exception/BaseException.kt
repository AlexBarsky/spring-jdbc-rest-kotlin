package ru.barsky.cargo.exception

import org.springframework.http.HttpStatus

abstract class BaseException(
    val errorCode: String,
    override val message: String,
    val status: HttpStatus,
):
    RuntimeException(message)

class CargoNotFoundException(id: Int): BaseException(
    errorCode = "CARGO_NOT_FOUND",
    message = "Cargo with id = $id not found",
    status = HttpStatus.NOT_FOUND,
)