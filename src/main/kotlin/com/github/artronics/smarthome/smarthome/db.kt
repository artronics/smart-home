package com.github.artronics.smarthome.smarthome

import jakarta.persistence.Entity
import jakarta.persistence.Id
import org.springframework.context.annotation.Bean
import org.springframework.core.env.Environment
import org.springframework.jdbc.datasource.DriverManagerDataSource
import org.springframework.stereotype.Component
import javax.sql.DataSource


@Entity(name = "entity_seq")
class EntitySequence {
    @Id
    var name: String? = null
    var seq: Long? = null
}

@Component
class Db(var env: Environment) {
    @Bean
    fun dataSource(): DataSource? {
        val dataSource = DriverManagerDataSource()
        with(dataSource) {
            setDriverClassName(env.getProperty("driverClassName")!!)
            url = env.getProperty("url")
            username = env.getProperty("username")
            password = env.getProperty("password")
        }

        return dataSource
    }
}
