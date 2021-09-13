package ru.personalarea.config

import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate
import ru.personalarea.config.handler.RestTemplateResponseErrorHandler

@Configuration
class AppConfig(
    private val restTempateErrorHandler: RestTemplateResponseErrorHandler
) {
    @Bean
    fun restTemplate(builder: RestTemplateBuilder): RestTemplate = builder
        .errorHandler(restTempateErrorHandler)
        .build()
}