package ru.personalarea.model.entity

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import ru.personalarea.repository.CardRepository

@SpringBootTest
internal class CardDtoTest(
    @Autowired private val repo: CardRepository
){
    @Test
    fun test(){
        val card = repo.findById(1345)
        println(11111)
        println(card)
        println(222222)
    }
}

