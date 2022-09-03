package ru.personalarea.integration.impl.gpn.dto.limit

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class LimitTerm(
    val days: String?,
    val time: LimitTermTime?,
    val type: Int
) {
}