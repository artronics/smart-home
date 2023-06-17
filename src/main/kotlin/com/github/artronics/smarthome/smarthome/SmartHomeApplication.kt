package com.github.artronics.smarthome.smarthome

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.boot.runApplication
import org.springframework.context.event.EventListener
import java.util.*


@SpringBootApplication
class SmartHomeApplication {
	@Autowired
	lateinit var repo: DeviceRepo

	@EventListener(ApplicationReadyEvent::class)
	fun loadBookTestData() {
		println("starting")
	}
}

fun main(args: Array<String>) {
	runApplication<SmartHomeApplication>(*args)
}
