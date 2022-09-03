package ru.personalarea.integration.impl.gpn.impl

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import ru.personalarea.integration.impl.HttpClientImpl
import ru.personalarea.integration.impl.gpn.GpnContractApi
import ru.personalarea.integration.impl.gpn.dto.contract.GetPartContractDataResponse

@Service
class GpnContractApiImpl(
    private val httpClient: HttpClientImpl
) : GpnContractApi {
    override fun getPartContractData(contractId: String): ResponseEntity<GetPartContractDataResponse> {
        TODO()
//        try {
//            val response = httpClient.getRequest<GetPartContractDataResponse>(
//                "/getPartContractData",
//                mapOf("contractId" to contractId),
//                GetPartContractDataResponse::class.java
//            )
//            return response
//        } catch (e: Exception) {
//            println(33333)
//            throw e
//        }

    }
}