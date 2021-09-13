package ru.personalarea.integration.gpn.impl.contract

import com.fasterxml.jackson.annotation.JsonProperty
import ru.personalarea.integration.gpn.impl.contract.BalanceData

data class PartContractData(
    @JsonProperty("balanceData")
    private val balanceData: BalanceData
) {
}