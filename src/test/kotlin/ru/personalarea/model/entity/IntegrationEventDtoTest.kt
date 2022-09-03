package ru.personalarea.model.entity

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import ru.personalarea.repository.IntegrationEventRepository

@SpringBootTest
internal class IntegrationEventDtoTest(
    @Autowired private val repo: IntegrationEventRepository
){

//    @Test
//    fun simpleTest(){
//        val integrationEventDto = IntegrationEventDto(
//            type = BLOCK,
//            obj = CARD,
//            content = "Карты заблокирована"
//        )
//        repo.save(integrationEventDto)
//    }
//
//    @Test
//    fun simpleTest2(){
//        val res = repo.findById(1)
//        println(res)
//    }
}