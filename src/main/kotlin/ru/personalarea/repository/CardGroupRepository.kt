package ru.personalarea.repository

import org.springframework.data.repository.CrudRepository
import ru.personalarea.model.entity.CardGroupDto

interface CardGroupRepository : CrudRepository<CardGroupDto, Long> {
}