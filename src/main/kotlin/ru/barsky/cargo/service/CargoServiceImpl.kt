package ru.barsky.cargo.service

import org.springframework.stereotype.Service
import ru.barsky.cargo.dto.CargoDto
import ru.barsky.cargo.model.Cargo
import ru.barsky.cargo.repository.CargoRepository

@Service
class CargoServiceImpl(
    private val cargoRepository: CargoRepository,
) : CargoService {
    override fun getAll(): List<CargoDto> =
        cargoRepository.getAll()
            .map { it.toDto() }

    override fun getById(id: Int): CargoDto =
        cargoRepository.findById(id)
            ?.toDto()
            ?: throw NoSuchElementException("No such cargo with id = $id")

    override fun create(dto: CargoDto) {
        TODO("Not yet implemented")
    }

    override fun update(id: Int, dto: CargoDto) {
        TODO("Not yet implemented")
    }

    override fun delete(id: Int) {
        TODO("Not yet implemented")
    }

    private fun Cargo.toDto(): CargoDto = CargoDto(
        id = id,
        title = title,
        passengerCount = passengerCount,
    )
}