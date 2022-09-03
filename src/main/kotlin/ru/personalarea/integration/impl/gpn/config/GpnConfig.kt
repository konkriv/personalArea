package ru.personalarea.integration.impl.gpn.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.web.client.RestTemplate
import ru.personalarea.integration.impl.gpn.handler.RestTemplateResponseErrorHandler
import ru.personalarea.repository.SessionRepository
import java.time.Duration
import java.time.LocalDateTime

@Configuration
data class GpnConfig(
    @Value("\${app.integration.gpn.auth.login}")
    private val login: String,
    private val repo: SessionRepository
) {
    val gpnSession = gpnSession()

    @Bean
    fun httpEntity() = HttpEntity<String>(headers())

    @Bean
    fun headers(): HttpHeaders {
        val headers = HttpHeaders()
        headers.set("session_id", gpnSession.sessionId)
        headers.set("api_key", gpnSession.token)
        headers.set("date_time", LocalDateTime.now().toString())
//        headers.set("Content-Type", "application/x-www-form-urlencoded")
//        headers.contentType = MediaType.APPLICATION_FORM_URLENCODED
        return headers
    }

    @Bean
    fun gpnUrl() = gpnSession.url + "/vip/v1"


    @Bean
    fun restTemplate(builder: RestTemplateBuilder): RestTemplate = builder
        .setReadTimeout(Duration.ofSeconds(600))
//        .errorHandler(restTempateErrorHandler())
        .build()

    private fun restTempateErrorHandler(): RestTemplateResponseErrorHandler =
        RestTemplateResponseErrorHandler(headers(), repo, login)

    private fun gpnSession() = repo.findSessionByLogin(login)
}