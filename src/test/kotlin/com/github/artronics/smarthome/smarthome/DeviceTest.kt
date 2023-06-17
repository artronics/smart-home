package com.github.artronics.smarthome.smarthome

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultHandlers

@SpringBootTest
@AutoConfigureMockMvc
//@ActiveProfiles(value = ["test"])
class DeviceTest {
    @Autowired
    lateinit var repo: DeviceRepo

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun test() {
        println("hoo")
        mockMvc.perform(post("/device?ip=192.168.0.23")).andDo(MockMvcResultHandlers.print())
        mockMvc.perform(post("/device?ip=192.168.0.23")).andDo(MockMvcResultHandlers.print())

    }
}
