package ru.barsky.cargo.service

import ru.barsky.cargo.dto.CargoDto

interface CargoService {
    fun getAll(): List<CargoDto>

    fun getById(id: Int): CargoDto

    fun create(dto: CargoDto)

    fun update(id: Int, dto: CargoDto)

    fun delete(id: Int)
}