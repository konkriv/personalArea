package ru.personalarea.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpHeaders
import ru.personalarea.repository.SessionRepository
import java.time.LocalDateTime

@Configuration
data class GpnConfig(
    @Value("\${app.integration.gpn.login}")
    private val login: String,
    private val repo: SessionRepository
) {
    val gpnSession = gpnSession()

    @Bean
    fun headersForGetRequest(): HttpHeaders {
        val headers = HttpHeaders()
        headers.set("api_key", gpnSession.token)
        headers.set("date_time", LocalDateTime.now().toString())
        headers.set("session_id", gpnSession.sessionId)
        return headers
    }

    @Bean
    fun headersForPostRequest(): HttpHeaders {
        val headers = headersForGetRequest()
        headers.set("Content-Type","application/x-www-form-urlencoded")
        return headers
    }

    @Bean
    fun gpnUrl() = gpnSession.url

    private fun gpnSession() =  repo.findSessionByLogin(login)
}