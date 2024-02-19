package ru.barsky.cargo.service

import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class BusinessScheduler(
    private val cargoService: CargoService,
) {

    @Scheduled(cron = "0 56 07 * * *")
    fun schedule() {
        cargoService.doForSchedule()
    }
}