package ru.personalarea.integration.impl.gpn.dto.limit

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class LimitAmount(
    val unit: String,
    val value: Double,
    val used: Double
) {
}