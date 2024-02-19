package ru.barsky.cargo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class SpringJdbcRestApplication

fun main(args: Array<String>) {
    runApplication<SpringJdbcRestApplication>(*args)
}
