package ru.personalarea.repository

import org.springframework.data.repository.CrudRepository
import ru.personalarea.model.entity.IntegrationEventDto

interface IntegrationEventRepository : CrudRepository <IntegrationEventDto, Long> {
}