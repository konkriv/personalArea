package ru.personalarea.integration.impl.gpn.dto.limit

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class LimitTransaction(
    val count: Int,
    val occured: Int
) {
}