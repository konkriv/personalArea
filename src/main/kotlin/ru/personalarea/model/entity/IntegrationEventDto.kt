package ru.personalarea.model.entity

import org.springframework.data.annotation.CreatedDate
import ru.personalarea.model.enum.IntegrationObject
import ru.personalarea.model.enum.IntegrationType
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class IntegrationEventDto(
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private val id: Long? = null,
    private val type: String,
    private val obj: String,
    private val content: String,
    private val createdAt: LocalDateTime = LocalDateTime.now()
) {

}