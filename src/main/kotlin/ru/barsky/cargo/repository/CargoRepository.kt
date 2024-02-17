package ru.barsky.cargo.repository

import ru.barsky.cargo.model.Cargo


interface CargoRepository {
    fun getAll(): List<Cargo>

    fun findById(id: Int): Cargo?

    fun create(model: Cargo)

    fun update(id: Int, model: Cargo)

    fun delete(id: Int)
}