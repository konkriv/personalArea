package ru.personalarea.integration.impl.gpn.impl

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import ru.personalarea.integration.impl.HttpClientImpl
import ru.personalarea.integration.impl.gpn.GpnTransactionApi

@Service
class GpnTransactionApiImpl(
    private val httpClient: HttpClientImpl
) : GpnTransactionApi {
    override fun getLast30Transactions(contractId: String): ResponseEntity<String> {
        TODO()
//        println("11111")
//        val result = httpClient.getRequest<String>(
//            serviceName = "/transactions",
//            params = mapOf("contractId" to contractId),
//            responseClass = String::class.java
//        )
//        println("22222222")
//        return result
    }

}