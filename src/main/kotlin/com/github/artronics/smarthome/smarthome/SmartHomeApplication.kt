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
		val d = Device()
//		d.id = UUID.randomUUID().toString()
//		d.id = 123
		repo.save(d)
		val r = Device()
		repo.save(r)
		println("saved")
	}
}

fun main(args: Array<String>) {
	runApplication<SmartHomeApplication>(*args)
}
