package ru.barsky.cargo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringJdbcRestApplication

fun main(args: Array<String>) {
    runApplication<SpringJdbcRestApplication>(*args)
}
