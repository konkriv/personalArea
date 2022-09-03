package ru.personalarea.integration.impl.gpn.dto.contract

import com.fasterxml.jackson.annotation.JsonProperty

data class PartContractData(
    @JsonProperty("balanceData")
    val balanceData: BalanceData
) {
}