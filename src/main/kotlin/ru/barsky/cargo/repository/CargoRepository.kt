package ru.barsky.cargo.repository

import ru.barsky.cargo.model.Cargo


interface CargoRepository {
    fun getAll(): List<Cargo>

    fun findById(id: Int): Cargo?

    fun create(title: String, passengerCount: Int?): Int

    fun update(id: Int, title: String, passengerCount: Int?)

    fun deleteById(id: Int)
}