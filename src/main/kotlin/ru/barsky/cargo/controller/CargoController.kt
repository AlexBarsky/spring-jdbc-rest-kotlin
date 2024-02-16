package ru.barsky.cargo.controller

import org.springframework.web.bind.annotation.*
import ru.barsky.cargo.dto.CargoDto

@RestController
@RequestMapping("/cargo")
class CargoController {

    @GetMapping("")
    fun getAll(): List<CargoDto> = listOf(
        CargoDto(
            id = 1,
            title = "Cargo 1",
        )
    )

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int): CargoDto = CargoDto(
        id = 1,
        title = "Cargo 1",
    )

    @PostMapping("/")
    fun create(@RequestBody dto: CargoDto) {

    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Int, @RequestBody dto: CargoDto) {

    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int) {

    }
}