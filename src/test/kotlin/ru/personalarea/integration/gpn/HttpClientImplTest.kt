//package ru.personalarea.integration.gpn
//
//import org.junit.jupiter.api.Test
//
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.boot.test.context.SpringBootTest
//import org.springframework.http.HttpHeaders
//import org.springframework.web.client.RestTemplate
//import ru.personalarea.integration.impl.gpn.dto.contract.GetPartContractDataResponse
//import ru.personalarea.integration.impl.HttpClientImpl
//
//@SpringBootTest
//internal class HttpClientImplTest(
//    @Autowired private val restTemplate: RestTemplate,
//    @Autowired private val headers: HttpHeaders,
//    @Autowired private val gpnUrl: String
//) {
//    val gpnHttpClient = HttpClientImpl(
//        restTemplate,
//        headers,
//        gpnUrl
//    )
//
//    @Test
//    fun getRequest() {
//        val result = gpnHttpClient.getRequest<GetPartContractDataResponse>(
//            "/getPartContractData",
//            mapOf("contractId" to "1-6Y7NH1W"),
//            GetPartContractDataResponse::class.java
//        )
//        print(result)
//    }
//
////    @Test
////    fun postReques2t() {
////        val gpnHttpClient = GpnHttpClient(gpnSessionTest, restTemplate)
////        val res = gpnHttpClient.postRequest2()
////        print(res)
////    }
//}