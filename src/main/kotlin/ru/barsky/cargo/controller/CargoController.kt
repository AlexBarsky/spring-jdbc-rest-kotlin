package ru.barsky.cargo.controller

import org.springframework.web.bind.annotation.*
import ru.barsky.cargo.dto.CargoDto
import ru.barsky.cargo.service.CargoService

@RestController
@RequestMapping("/cargo")
class CargoController(
    private val cargoService: CargoService,
) {

    @GetMapping
    fun getAll(@RequestParam("page") pageIndex: Int): List<CargoDto> = cargoService.getAll(pageIndex)

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int): CargoDto = cargoService.getById(id)

    @PostMapping
    fun create(@RequestBody dto: CargoDto): Int =
        cargoService.create(dto)

    @PutMapping("/{id}")
    fun update(@PathVariable id: Int, @RequestBody dto: CargoDto) {
        cargoService.update(id, dto)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int) {
        cargoService.deleteById(id)
    }
}