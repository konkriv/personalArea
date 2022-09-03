package ru.personalarea.integration.impl.gpn.dto.`card-group`

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
class GpnCardGroupListResponseDto(
    @JsonProperty(value = "total_count")
    val totalCount: Int,
    @JsonProperty(value = "result")
    val cardGroupList: List<GpnCardGroupDataResponseDto>
) {
}