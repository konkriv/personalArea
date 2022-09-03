package ru.personalarea.integration.impl.gpn.dto.limit

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(NON_NULL)
class LimitSum(
    val currency: String,
    var value: Int,
    val used: Double? = null,
    val currencyName: String? = null
) {
}