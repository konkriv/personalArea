package ru.personalarea.integration.impl.gpn.dto.limit

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
class LimitResponseData(
    @JsonProperty("total_count")
    val totalCount: Int,
    @JsonProperty("result")
    val limits: List<LimitData>?
) {
}