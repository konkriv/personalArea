package ru.personalarea.integration.impl.gpn

import org.springframework.http.ResponseEntity
import ru.personalarea.integration.impl.gpn.dto.contract.GetPartContractDataResponse

interface GpnContractApi {
    fun getPartContractData(contractId: String): ResponseEntity<GetPartContractDataResponse>
}