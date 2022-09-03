package ru.personalarea.repository

import org.springframework.data.repository.CrudRepository
import ru.personalarea.model.entity.CardDto

interface CardRepository : CrudRepository<CardDto, Long> {
    fun findByIdIn(ids: List<Long>): List<CardDto>
    fun findBySourceIdIn(sourceIdS: List<String>): List<CardDto>
    fun findByCardNumberIn(cardNumbers: List<Long>): List<CardDto>
}