package ru.personalarea.integration.impl

import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod.GET
import org.springframework.http.HttpMethod.POST
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.util.LinkedMultiValueMap
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity
import org.springframework.web.util.UriBuilder
import org.springframework.web.util.UriComponentsBuilder
import ru.personalarea.integration.HttpClient


@Service
class HttpClientImpl(
    private val restTemplate: RestTemplate,
    private val httpEntity: HttpEntity<String>,
    private val gpnUrl: String,
) : HttpClient {

    override fun <T> getRequest(
        serviceName: String,
        params: LinkedMultiValueMap<String, String>,
        responseClass: Class<T>
    ): ResponseEntity<T> {
        val uri = UriComponentsBuilder
            .fromHttpUrl(gpnUrl + serviceName)
            .queryParams(params)

        return restTemplate.exchange(uri.toUriString(), GET, httpEntity, responseClass, params)
    }

    override fun <T> postRequest(
        serviceName: String,
        params: Map<String, Any>,
        responseClass: Class<T>
    ): ResponseEntity<T> {
        val fullServiceUrl = gpnUrl + serviceName
        val request = HttpEntity(params, httpEntity.headers)
        return restTemplate.postForEntity(fullServiceUrl, request, responseClass)
    }
}