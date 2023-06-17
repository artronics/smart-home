package com.github.artronics.smarthome.smarthome

import jakarta.persistence.*
import org.springframework.data.repository.CrudRepository
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@Entity
class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "sqlite")
    @TableGenerator(
        name = "sqlite", table = "entity_seq",
        pkColumnName = "name", valueColumnName = "seq",
        pkColumnValue = "device_id"
    )
    var id: Long? = null
}

interface DeviceRepo : CrudRepository<Device, Long> {
    fun findDeviceById(id: Long): Device
}

@RestController
@RequestMapping(value = ["/device"])
class DeviceController(private val deviceRepo: DeviceRepo) {
    @PostMapping
    fun addDevice(@RequestParam ip: String): String {
        val d = Device()
        deviceRepo.save(d)
        return "Ok"
    }

}
