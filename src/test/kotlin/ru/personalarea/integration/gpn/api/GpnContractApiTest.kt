package ru.personalarea.integration.gpn.api

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpHeaders
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.support.AnnotationConfigContextLoader
import org.springframework.web.client.RestTemplate
import ru.personalarea.config.GpnConfig
import ru.personalarea.integration.gpn.GpnHttpClient
import ru.personalarea.model.Session

@SpringBootTest
internal class GpnContractApiTest(
    @Autowired private val restTemplate: RestTemplate,
    @Autowired private val headersForGetRequest: HttpHeaders,
    @Autowired private val headersForPostRequest: HttpHeaders,
    @Autowired private val gpnUrl: String
) {
    val gpnHttpClient = GpnHttpClient(
        restTemplate,
        headersForGetRequest,
        headersForPostRequest,
        gpnUrl
    )

    @Test
    fun getPartContractData() {
        val result = GpnContractApi(gpnHttpClient).getPartContractData("1-6Y7NH1W")
        print(result)
    }
}