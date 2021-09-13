package ru.personalarea.integration.gpn

import org.springframework.http.*
import org.springframework.http.HttpMethod.GET
import org.springframework.http.HttpMethod.POST
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.time.LocalDateTime.now

@Service
class GpnHttpClient(
    private val restTemplate: RestTemplate,
    private val headersForGetRequest: HttpHeaders,
    private val headersForPostRequest: HttpHeaders,
    private val gpnUrl: String
) {
    fun <T> getRequest(serviceName: String, params: Map<String, String>, responseClass: Class<T>): ResponseEntity<T> {

        val httpEntity = HttpEntity<String>(headersForGetRequest)
        val fullServiceUrl = gpnUrl + serviceName

//        val result : ResponseEntity<String> = restTemplate.exchange(fullServiceUrl, GET, httpEntity, String::class.java, params)
        return restTemplate.exchange(fullServiceUrl, GET, httpEntity, responseClass, params)
    }

//    fun postRequest(service: String, params: Map<String, String>) {
//        val url = "https://apidemo.opti-24.com"
//        val headers = HttpHeaders()
//        headers.set("api_key", "GPN.3bd43c4463ffe8b23fb5d1891dc6b.d53a3a7e0a50ef94123fdc5b29780")
//        headers.set("date_time", now().toString())
//
//
//        val httpEntity = HttpEntity(
//            "login=demo&password=26c669cd0814ac40e5328752b21c4aa6450d16295e4eec30356a06a911c23983aaebe12d5da38eeebfc1b213be650498df8419194d5a26c7e0a50af156853c79",
//            headers
//        )
//        val fullServiceUrl = "https://apidemo.opti-24.com/vip/v1/authUser"
//        val result: ResponseEntity<String> = restTemplate.exchange(fullServiceUrl, POST, httpEntity, String::class.java)
//
//    }

}