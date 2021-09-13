package ru.personalarea.integration.gpn.impl.contract

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class GetPartContractDataResponse(
    @JsonProperty("data")
    private val partContractData: PartContractData
) {
}