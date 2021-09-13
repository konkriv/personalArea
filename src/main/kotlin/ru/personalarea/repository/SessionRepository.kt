package ru.personalarea.repository

import org.springframework.data.repository.CrudRepository
import ru.personalarea.model.Session

interface SessionRepository : CrudRepository<Session, Long> {
    fun findSessionByUrl(url: String): Session
    fun findSessionByLogin(login: String): Session
}