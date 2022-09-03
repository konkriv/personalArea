package ru.personalarea.repository

import org.springframework.data.repository.CrudRepository
import ru.personalarea.model.entity.SessionDto

interface SessionRepository : CrudRepository<SessionDto, Long> {
    fun findSessionByUrl(url: String): SessionDto
    fun findSessionByLogin(login: String): SessionDto
}