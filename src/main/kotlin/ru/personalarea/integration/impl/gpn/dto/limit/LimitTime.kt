package ru.personalarea.integration.impl.gpn.dto.limit

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class LimitTime(
    val type: Int,
    val number: Int
) {
}