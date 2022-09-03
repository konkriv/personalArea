package ru.personalarea.integration.impl.gpn.dto.contract

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown=true)
data class BalanceData(
    @JsonProperty("balance")
    val balance: Double
) {
}