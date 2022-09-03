package ru.personalarea.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.personalarea.model.entity.CardStatusDto

@Repository
interface CardStatusRepository : CrudRepository<CardStatusDto, Long> {
    fun findBySourceId(sourceId: String): CardStatusDto
}