package ru.personalarea.integration

import org.springframework.http.ResponseEntity
import org.springframework.retry.annotation.Backoff
import org.springframework.retry.annotation.Retryable
import org.springframework.util.LinkedMultiValueMap
import org.springframework.web.client.HttpStatusCodeException

interface HttpClient {
//    @Retryable(
//        value = [HttpStatusCodeException::class],
//        maxAttemptsExpression = "\${app.integration.gpn.retry.maxAttempts}",
//        backoff = Backoff(delayExpression = "\${app.integration.gpn.retry.delay}")
//    )
    fun <T> getRequest(serviceName: String, params: LinkedMultiValueMap<String, String>, responseClass: Class<T>): ResponseEntity<T>
    fun <T> postRequest(serviceName: String, params: Map<String, Any>, responseClass: Class<T>): ResponseEntity<T>
}