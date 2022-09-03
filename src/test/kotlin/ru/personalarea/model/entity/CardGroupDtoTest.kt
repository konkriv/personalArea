package ru.personalarea.model.entity

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import ru.personalarea.repository.CardGroupRepository

@SpringBootTest
internal class CardGroupDtoTest(
    @Autowired private val repo: CardGroupRepository
){

    @Test
    fun test(){
        val cg = repo.findAll()
        println(cg)
    }
}