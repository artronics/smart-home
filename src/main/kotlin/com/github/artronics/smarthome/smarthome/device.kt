package com.github.artronics.smarthome.smarthome

import jakarta.persistence.*
import org.springframework.data.repository.CrudRepository

@Entity(name = "entity_seq")
class EntitySequence {
    @Id
    var name: String? = null
    var seq: Long? = null
}

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
