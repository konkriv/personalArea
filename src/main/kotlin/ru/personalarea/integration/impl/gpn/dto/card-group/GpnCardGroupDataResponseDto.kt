package ru.personalarea.integration.impl.gpn.dto.`card-group`

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class GpnCardGroupDataResponseDto(
    val id: String,
    val name: String,
    @JsonProperty(value = "cards_count")
    val cardsCount: Int,
    val status: String,
    @JsonProperty(value = "contract_id")
    val contractSourceId: String
) {
}