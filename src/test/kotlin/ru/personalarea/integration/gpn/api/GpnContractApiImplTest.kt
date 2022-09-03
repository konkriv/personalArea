//package ru.personalarea.integration.gpn.api
//
//import org.junit.jupiter.api.Test
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.boot.test.context.SpringBootTest
//import org.springframework.http.HttpHeaders
//import org.springframework.web.client.RestTemplate
//import ru.personalarea.integration.impl.HttpClientImpl
//import ru.personalarea.integration.impl.gpn.impl.GpnContractApiImpl
//import ru.personalarea.repository.SessionRepository
//
//@SpringBootTest
//internal class GpnContractApiImplTest(
//    @Autowired private val restTemplate: RestTemplate,
//    @Autowired private val headers: HttpHeaders,
//    @Autowired private val gpnUrl: String,
//    @Autowired private val sessionRepo: SessionRepository
//) {
//    val gpnHttpClientImpl = HttpClientImpl(
//        restTemplate,
//        headers,
//        gpnUrl,
//        sessionRepo
//    )
//
//    @Test
//    fun getPartContractData() {
//        val result = GpnContractApiImpl(gpnHttpClientImpl).getPartContractData("6")
//        print(result)
//    }
//}