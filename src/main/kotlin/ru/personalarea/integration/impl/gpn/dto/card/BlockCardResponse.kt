package ru.personalarea.integration.impl.gpn.dto.card

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import ru.personalarea.integration.impl.gpn.dto.contract.PartContractData

@JsonIgnoreProperties(ignoreUnknown = true)
class BlockCardResponse(
    @JsonProperty("data")
    val cardsIds: List<String>
) {
}