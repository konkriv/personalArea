package ru.personalarea.integration.gpn.api

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import ru.personalarea.integration.gpn.GpnHttpClient
import ru.personalarea.integration.gpn.impl.contract.GetPartContractDataResponse

@Service
class GpnContractApi(
    private val gpnHttpClient: GpnHttpClient
) {
    fun getPartContractData(contractId: String): ResponseEntity<GetPartContractDataResponse> {
        val result = gpnHttpClient.getRequest<GetPartContractDataResponse>("/getPartContractData", mapOf("contractId" to contractId), GetPartContractDataResponse::class.java)
        return result
    }
}